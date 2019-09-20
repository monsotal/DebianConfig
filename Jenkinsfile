#!groovy

pipeline {
    agent any
    
    options {
    buildDiscarder(logRotator(daysToKeepStr: '14', numToKeepStr: '10'))
  }

	triggers {
  pollSCM '* * * * *'
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
        
        stage('Publish "Checkstyle" Code review results') {
			steps {
				build 'Publish_checkstyle_results'
	}
}
        
          stage('Deploy') {
            steps {
                echo 'Deploying'
            }
        }
    }
}
