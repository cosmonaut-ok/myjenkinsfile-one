import hudson.FilePath;

node('linux') {
    library identifier: 'jenkins-libs@TESTAUTO-1532-flow-for-test-automation',
        retriever: modernSCM(github(credentialsId: 'b3cae613-c8f3-4f12-bcd5-75988c058d9a',
                                    id: '845e0207-1837-425f-b354-fe99baf714c1',
                                    repoOwner: 'ThomasCookOnline',
                                    repository: 'jenkins-libs',
                                    traits: [headRegexFilter('TESTAUTO-1532-flow-for-test-automation')]))

    checkout([
        $class: 'GitSCM',
        branches: [[name: '*/master']],
        doGenerateSubmoduleConfigurations: false,
        extensions: [
            [
                $class: 'SubmoduleOption',
                disableSubmodules: false,
                parentCredentials: false,
                recursiveSubmodules: true,
                reference: '', trackingSubmodules: false
            ]
        ],
        submoduleCfg: [],
        userRemoteConfigs:
            [
            [credentialsId: 'b3cae613-c8f3-4f12-bcd5-75988c058d9a',
             url: 'https://github.com/ThomasCookOnline/DigitalAutomationTesting.git'
            ]
        ]
    ])

    scm checkout

    runPipeline('githubflow') {
        appName = 'DigitalAutomationTesting'
        platform = 'nodejs'
        baseContainerVersion = '8.9.4'
        // role = 'sponsorship-api'
        // cookbookName = 'tc-sponsorship-api'
        // notificationEmail = 'panthers@thomascookonline.com'
        // npm_run_args = 'fe:build';
    }
}
