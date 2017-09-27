def gitUrl = 'git://github.com/jenkinsci/job-dsl-plugin.git'
def branches = ['master','release/1.0','feature/some-new-stuff']

branches.each { branch ->
  
  def jobName = "demo6-${branch}".replaceAll('/','-')
    
  def myjob = job(jobName) {
    scm {
        git(gitUrl, branch)
    }
    triggers {
        scm('*/15 * * * *')
    }
  } 
  
  if (branch == "master" || branch.startsWith("release")) {
    myjob.with {
      steps {
        maven('-e deploy clean test')
      }
    }
  } else {
    myjob.with {
      steps {
        maven('-e clean test')
      }
    }
  }
}
