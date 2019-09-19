#!groovy

pipeline {
    agent any
    
    options {
    buildDiscarder(logRotator(daysToKeepStr: '14', numToKeepStr: '10'))
  }

    stages {
        stage('Initialize Debian_Config_PIPELINE') {
            steps {
                sh 'mvn --version'
            }
        }
        stage('Build') {
            steps {
                echo 'Building'
                sh 'mvn clean install checkstyle:checkstyle'
            }
        }
        
          stage('Deploy') {
            steps {
                echo 'Deploying'
            }
        }
    }
}
