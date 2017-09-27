def gitUrl = 'git://github.com/jenkinsci/job-dsl-plugin.git'

job('demo1') {
    scm {
        git(gitUrl)
    }
    triggers {
        scm('*/15 * * * *')
    }
    steps {
        maven('-e clean test')
    }
}