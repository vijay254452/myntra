pipeline {
    agent any

    environment {
        DOCKER_HUB = 'vijay3247/myntra'   // change to your DockerHub repo
        DOCKER_CREDENTIALS = credentials('dockerhub-credentials') // Jenkins credentials ID
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/vijay254452/myntra.git'
            }
        }

        stage('Build WAR') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t $DOCKER_HUB:latest .'
            }
        }

        stage('Push Docker Image') {
            steps {
                withDockerRegistry([credentialsId: 'dockerhub-credentials', url: '']) {
                    sh 'docker push $DOCKER_HUB:latest'
                }
            }
        }

        stage('Deploy Local Container') {
            steps {
                sh '''
                docker rm -f myntra || true
                docker run -d --name myntra -p 8777:8080 $DOCKER_HUB:latest
                '''
            }
        }
    }
}

