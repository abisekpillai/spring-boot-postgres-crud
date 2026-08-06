pipeline {
    agent any

    tools {
        maven 'Maven3'
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

        stage('Version WAR') {
            steps {
                sh '''
                VERSION=1.0.${BUILD_NUMBER}-$(git rev-parse --short HEAD)

                cp target/*.war target/${APP_NAME}-${VERSION}.war

                echo ${VERSION} > target/version.txt
                '''
            }
        }

        stage('Deploy') {
            steps {
                sh '''
                VERSION=$(cat target/version.txt)

                rm -rf ${TOMCAT_WEBAPPS}/${APP_NAME}
                rm -f ${TOMCAT_WEBAPPS}/${APP_NAME}.war

                cp target/${APP_NAME}-${VERSION}.war \
                   ${TOMCAT_WEBAPPS}/${APP_NAME}.war
                '''
            }
        }
    }

    post {
        success {
            archiveArtifacts artifacts: 'target/*.war'
        }
    }
}
