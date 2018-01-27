import utilities.GitUtils

def project = 'automate-jenkins-job-creation'
def repo = "https://tonivdv@bitbucket.org/tonivdv/${project}.git"

def branches = GitUtils.getRemoteBranches(repo, out)

folder('demo5bis')

branches.each {

    def branchName = it
    def jobName = "demo5bis/demo5bis-${project}-${branchName}".replaceAll('/','-')
    job(jobName) {
        scm {
            git("https://github.com/${project}.git", branchName)
        }
    }

}
