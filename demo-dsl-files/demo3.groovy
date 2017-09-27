def gitUrl = 'git://github.com/jenkinsci/job-dsl-plugin.git'
def branches = ['master','dev','hotfix']

branches.each { branch ->
    
  job("demo3-${branch}") {
    scm {
        git(gitUrl, branch)
    }
    triggers {
        scm('*/15 * * * *')
    }
    steps {
        maven('-e clean test')
    }
  }    
}
