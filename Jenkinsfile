pipeline {
    agent any

    tools {
        maven 'MAVEN_HOME'
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('SonarQube Code Check'){
            environment{
                scannerHome= tool 'sonarqube-scanner'
            }
            steps {
                withSonarQubeEnv('sonarqube-server'){
                    sh '${scannerHome}/bin/sonar-scanner'
                }
            }
        }
    }
}

