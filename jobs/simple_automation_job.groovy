import hudson.FilePath;

node('linux') {

    git credentialsId: 'b3cae613-c8f3-4f12-bcd5-75988c058d9a', url: '${scm_url}'

    docker.image('${container}').inside("-u 1000:996") {

        // stage('motherfucker') {
        sh '''
        set -x

    npm prune
    npm install
    rm -rf ${allure_path}
    node run ${args}
    '''

        // allure includeProperties: false, jdk: '', results: [[path: '${allure_path}']]
        // }
    }
}
