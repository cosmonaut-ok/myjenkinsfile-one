#!/usr/bin/env groovy
import hudson.plugins.git.*;
// import groovy.io.FileType;
import hudson.FilePath;

node('linux') {
    stage('Get the fucking repo')
    {
        git changelog: false,
        credentialsId: 'b3cae613-c8f3-4f12-bcd5-75988c058d9a',
        poll: false,
        url: 'https://github.com/cosmonaut-ok/myjenkinsfile-one.git'
    }
    stage('Make Monkey Code!') {
        if (env.BRANCH_NAME == 'master') {
            echo 'I only execute on the master branch'
            create_automation_job("gogogo")
        } else {
            echo 'I execute elsewhere'
        }
    }
}

// def getDirectoryFiles(dir)
// {
//     def list = []

//     def dir = new File("path_to_parent_dir")
//     dir.eachFileRecurse (FileType.FILES) { file ->
//         list << file
//     }
//     return list
// }

def loadResource(file)
{
    String fileContents = new File(file).text
    return fileContents
}

def create_automation_job (name, scm_url = "git@github.com:cosmonaut-ok/myjenkinsfile-one.git", branch = "*/master", args = "themotherfucker")
{
// def hello () {
    def scm = new GitSCM(scm_url)
    scm.branches = [new BranchSpec(branch)];

    def flowDefinition = new org.jenkinsci.plugins.workflow.cps.CpsFlowDefinition(
        '''
        // loadResource("fuckme.groovy"),
        echo 'hello world'
''',
        true)

    def parent = Jenkins.instance
    def job = new org.jenkinsci.plugins.workflow.job.WorkflowJob(parent, name)
    job.definition = flowDefinition

    parent.reload()
}
