#!/usr/bin/env groovy
import hudson.plugins.git.*;
// import groovy.io.FileType;
import hudson.FilePath;
import groovy.io.FileType;

// for view
import jenkins.model.Jenkins
import hudson.model.ListView

node('linux') {
    stage('Get the fucking repo')
    {
        checkout scm
        sh 'ls -lhrt'
        // git changelog: false,
        //     credentialsId: 'b3cae613-c8f3-4f12-bcd5-75988c058d9a',
        //     poll: true,
        //     url: 'https://github.com/cosmonaut-ok/myjenkinsfile-one.git'
    }
    stage('Make Monkey Code!') {
        def zzz = getDirectoryFiles("jobs")
        if (env.BRANCH_NAME == 'master') {
            echo 'I only execute on the master branch'
            zzz.each {
                echo "${it}"
            }

            create_job_view('my_view')
            create_automation_job("gogogo-1")
        } else {
            echo 'I execute elsewhere'
        }
    }
}

def getDirectoryFiles(dir)
{
    def rootDir = pwd()
    def list = []

    def listDir = new File("${rootDir}/${dir}")
    listDir.eachFileRecurse (FileType.FILES) { file ->
        list << file
    }
    return list
}

def loadResource(file)
{
    def rootDir = pwd()
    // println("Current Directory from loadResource: " + rootDir)

    String fileContents = new File("${rootDir}/${file}").text
    return fileContents
}

def create_automation_job (name, scm_url = "https://github.com/ThomasCookOnline/DigitalAutomationTesting.git",
                           branch = "*/master", args = "themotherfucker", container='node:8')
{
// def hello () {
    def scm = new GitSCM(scm_url)
    scm.branches = [new BranchSpec(branch)];

    def allure_path = 'allure-results'

    def flowDefinition = new org.jenkinsci.plugins.workflow.cps.CpsFlowDefinition(
        """
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

""", true)

    def parent = Jenkins.instance
    def job = new org.jenkinsci.plugins.workflow.job.WorkflowJob(parent, name)
    job.definition = flowDefinition

    parent.reload()
}


def create_job_view(name)
{
    // get Jenkins instance
    def jenkinsInstance = Jenkins.getInstance()

    def isView = jenkinsInstance.getView(name)
    // create the new view
    if (!isView) {
        jenkinsInstance.addView(new ListView(name))
    }

    // // get the view
    // def myView = hudson.model.Hudson.instance.getView(name)

    // // add a job by its name
    // myView.doAddJobToView('MyJob1')
    // myView.doAddJobToView('MyJob2')
    // myView.doAddJobToView('MyJob3')

    // save current Jenkins state to disk
    jenkinsInstance.save()

    // def create_
    // loadResource('jobs/simple_automation_job.groovy')
}
