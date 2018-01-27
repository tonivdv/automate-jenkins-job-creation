package utilities

public class GitUtils {

  public static String[] getRemoteBranches(def repoUrl, def out) {

    Process proc1 = "git ls-remote -h ${repoUrl}".execute()
    Process proc2 = 'sed s/.*refs\\/heads\\///g'.execute()
    Process all = proc1 | proc2
    all.waitFor()

    out.println "### DEBUG: Begin ###"
    out.println "Error Code: ${all.exitValue()}"
    out.println "Error Message: ${all.err.text}"
    out.println "### DEBUG: End ###"

    def branches = "${all.in.text}".split('\\n')

    return branches
  }
}
