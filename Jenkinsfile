pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "harshitha1408/spring-crud-demo:latest"
        K8S_NAMESPACE = "microservices-demo"
        DEPLOYMENT_NAME = "user-service"
    }

    stages {

        stage('Checkout Code') {
            steps {
                checkout scm
            }
        }

        stage('Build JAR') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh "docker build -t $DOCKER_IMAGE ."
            }
        }

        stage('Push Docker Image') {
            steps {
                sh "docker push $DOCKER_IMAGE"
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                sh "kubectl -n $K8S_NAMESPACE set image deployment/$DEPLOYMENT_NAME $DEPLOYMENT_NAME=$DOCKER_IMAGE"
            }
        }
    }
}
