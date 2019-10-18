#!groovy

pipeline {
    agent any
    
    options {
    
    // To keep only the last 10 builds  & delete build that are older than 14 days. 
    
    buildDiscarder(logRotator(daysToKeepStr: '14', numToKeepStr: '10'))
  }

	triggers {
	
	// poll the code from remote repository , every 1 minute
	
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
            
            // run maven goals, then archiving artifacts: the executable jar file.
            
                echo 'Building'
                sh 'mvn clean install checkstyle:checkstyle pmd:pmd pmd:cpd findbugs:findbugs'
                
                recordIssues enabledForFailure: true, tool: checkStyle()
                recordIssues enabledForFailure: true, tool: spotBugs()
                recordIssues enabledForFailure: true, tool: cpd(pattern: '**/target/cpd.xml')
                recordIssues enabledForFailure: true, tool: pmdParser(pattern: '**/target/pmd.xml')
                
        		echo 'Now archiving .jar files'
            	archiveArtifacts artifacts : "**/*.jar"
        	}
        }
        

       
      stage('Deploy') {
    	steps {
    	
    	// Publish the archived artifact to 'internal host' for functionality testing/production..
    	
            echo 'Deploying'
           build job : 'Deployment_to_internal_host'

            }
        }
	}
}