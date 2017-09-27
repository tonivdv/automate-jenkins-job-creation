def project = 'automate-jenkins-job-creation'
def repo = "https://tonivdv@bitbucket.org/tonivdv/${project}.git"

Process proc1 = "git ls-remote -h ${repo}".execute()
Process proc2 = 'sed s/.*refs\\/heads\\///g'.execute()
Process all = proc1 | proc2
all.waitFor()

def branches = "${all.in.text}".split('\\n')

branches.each {

    def branchName = it
    def jobName = "demo5-${project}-${branchName}".replaceAll('/','-')
    job(jobName) {
        scm {
            git("https://github.com/${project}.git", branchName)
        }
    }

}