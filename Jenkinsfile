#!/usr/bin/env groovy

node {
    agent { label "linux" }
    stage('Example') {
        if (env.BRANCH_NAME == 'master') {
            echo 'I only execute on the master branch'
            hello()
        } else {
            echo 'I execute elsewhere'
        }
    }
}



def hello () {
    echo 'hello'
}
