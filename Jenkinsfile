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

            
    		post{
    			success{
                
                try{
                
        		echo 'Now archiving .jar files'
            	archiveArtifacts artifacts : "**/*.jar"
                
            	}
            
				catch(Exception e){
				e.printStackTrace();
				}

        		}    
                
    		}
        }
        	
      stage('Deploy') {
        steps {
            echo 'Deploying'
           build job : ''

            }
        }
    }
}
