pipeline {
    agent any

    stages {
        stage('Clone Repository') {
            steps {
                git 'https://github.com/Dikshant-Mahawar/Calculator.git'
            }
        }

        stage('Build with Maven') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t calculator-app .'
            }
        }

        stage('Push to Docker Hub') {
            environment {
                DOCKER_HUB_USER = 'dikshant0012'
                DOCKER_HUB_PASS = credentials('dockerhub-credentials-id')
            }
            steps {
                sh '''
                echo "$DOCKER_HUB_PASS" | docker login -u "$DOCKER_HUB_USER" --password-stdin
                docker tag calculator-app $DOCKER_HUB_USER/calculator-app:latest
                docker push $DOCKER_HUB_USER/calculator-app:latest
                '''
            }
        }
    }
}
