pipeline {
    agent any

    tools {
        maven 'Maven3'
        jdk "JDK17"
    }

    environment {
        APP_NAME = 'springbootpostgrescrud'
        TOMCAT_WEBAPPS = '/var/lib/tomcat10/webapps'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/abisekpillai/spring-boot-postgres-crud.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Deploy') {
            steps {
                sh 'cp target/*.war /var/lib/tomcat10/webapps/ROOT.war'
            }
        }
    }

    post {
        success {
            archiveArtifacts artifacts: 'target/*.war'
        }
    }
}
