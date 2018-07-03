#!/usr/bin/env groovy

pipeline {
    agent { node { label 'linux' } }

    options {
        buildDiscarder(logRotator(numToKeepStr: '3', artifactNumToKeepStr: '1'))
    }
    shit {
        stages {
            stage('test') {
                steps {
                    sh 'echo "execute say hello script:"'
                    // body()
                    // sayHello("Peter")
                }
            }
        }
    }
    post {
        always {
            cleanWs()
        }
    }
}
}
