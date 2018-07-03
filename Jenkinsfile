#!/usr/bin/env groovy

shit {
pipeline {
    agent { node { label 'linux' } }

    options {
        buildDiscarder(logRotator(numToKeepStr: '3', artifactNumToKeepStr: '1'))
    }

    stages {
        stage('test') {
            steps {
                sh 'echo "execute say hello script:"'
                // body()
                // sayHello("Peter")
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
