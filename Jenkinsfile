pipeline {
    agent any

    tools {
        maven 'MAVEN_HOME'
    }
    stages {
        stage('Debug') {
            steps {
                sh 'whoami'
                sh 'echo $PATH'
                sh 'which mvn'
                sh 'mvn -version'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
    }
}
