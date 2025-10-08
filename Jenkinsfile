pipeline {
    agent any

    environment {
        PATH = "/opt/homebrew/Cellar/maven/3.9.11/bin:/usr/local/bin:/opt/homebrew/bin:$PATH"
    }

    stages {
        stage('Clone Repository') {
            steps {
                git branch: 'main', url: 'https://github.com/Dikshant-Mahawar/Calculator.git'
            }
        }

        stage('Build with Maven') {
            steps {
                sh '''
                    echo "Using Maven version:"
                    mvn -version
                    mvn clean package
                '''
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Build Docker Image') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub-credentials',   // make sure ID matches Jenkins
                    usernameVariable: 'DOCKER_HUB_USER',
                    passwordVariable: 'DOCKER_HUB_PASS'
                )]) {
                    sh '''
                        echo "Building Docker image..."
                        docker build -t "$DOCKER_HUB_USER"/calculator-app:latest .
                    '''
                }
            }
        }

        stage('Push to Docker Hub') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub-credentials',
                    usernameVariable: 'DOCKER_HUB_USER',
                    passwordVariable: 'DOCKER_HUB_PASS'
                )]) {
                    sh '''
                        echo "$DOCKER_HUB_PASS" | docker login -u "$DOCKER_HUB_USER" --password-stdin
                        docker push "$DOCKER_HUB_USER"/calculator-app:latest
                    '''
                }
            }
        }
    }

    post {
        success {
            echo "✅ Build and push successful!"
        }
        failure {
            echo "❌ Build failed. Check console output for details."
        }
    }
}
