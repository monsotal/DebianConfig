#!groovy

pipeline {
    agent any
    stages {
        stage('Initialize Debian_Config_PIPELINE') {
            steps {
                sh 'mvn --version'
            }
        }
        stage('Build') {
            steps {
                echo 'Building'
            }
        }
    }
}
