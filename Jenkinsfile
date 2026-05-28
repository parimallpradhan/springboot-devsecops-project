pipeline {

    agent any

    tools {
        jdk 'jdk17'
        maven 'maven3'
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'feature/product-api',
                url: 'https://github.com/parimallpradhan/springboot-devsecops-project.git'
            }
        }

        stage('Build & Test') {
            steps {
		script {
               sh 'mvn clean test'
		 }
            }
        }

 	stage('SonarQube Analysis') {
            steps {
		script {
               	withSonarQubeEnv('sonarqube') {

                    sh '''
                    mvn sonar:sonar \
                    -Dsonar.projectKey=ecommerce-app
                    '''
                }

		 }
            }
        }

    stage('Quality Gate') {
            steps {

                timeout(time: 5, unit: 'MINUTES') {

                    waitForQualityGate abortPipeline: true
                }
            }
        }

    stage('Package') {
            steps {
		script {
	                sh 'mvn package'
		 }
            }
        }


    }
}
