#!/usr/bin/env groovy
import hudson.plugins.git.*;

node('linux') {
    stage('Make Monkey Code!') {
        if (env.BRANCH_NAME == 'master') {
            echo 'I only execute on the master branch'
            hello()
        } else {
            echo 'I execute elsewhere'
        }
    }
}

def hello () {
    def scm = new GitSCM("git@github.com:cosmonaut-ok/myjenkinsfile-one.git")
    scm.branches = [new BranchSpec("*/master")];

    def flowDefinition = new org.jenkinsci.plugins.workflow.cps.CpsFlowDefinition(script, "fuckme.groovy")

    def parent = Jenkins.instance
    def job = new org.jenkinsci.plugins.workflow.job.WorkflowJob(parent, "The Very New Job!")
    job.definition = flowDefinition

    parent.reload()
}
