def registry = 'https://trialqw3aif.jfrog.io'

pipeline {
    agent any

    tools {
        maven 'MAVEN_HOME'
    }

    stages {

        stage('Build') {
            steps {
                echo '------------ Build Started ------------'
                sh 'mvn clean package -Dmaven.test.skip=true'
                echo '------------ Build Completed ------------'
            }
        }

        stage('Jar Publish') {
            steps {
                script {

                    echo '------------ Jar Publish Started ------------'

                    def server = Artifactory.newServer(
                        url: registry + "/artifactory",
                        credentialsId: "jfrog-cred"
                    )

                    def properties = "buildid=${env.BUILD_ID},commitid=${env.GIT_COMMIT}"

                    def uploadSpec = """{
                        "files": [
                            {
                                "pattern": "target/*.jar",
                                "target": "amaan-libs-release-local/",
                                "flat": "false",
                                "props": "${properties}",
                                "exclusions": ["*.sha1","*.md5"]
                            }
                        ]
                    }"""

                    def buildInfo = server.upload(uploadSpec)

                    buildInfo.env.collect()
                    server.publishBuildInfo(buildInfo)

                    echo '------------ Jar Publish Completed ------------'
                }
            }
        }
    }

    post {
        success {
            echo 'Pipeline Executed Successfully'
        }

        failure {
            echo 'Pipeline Failed'
        }
    }
}
