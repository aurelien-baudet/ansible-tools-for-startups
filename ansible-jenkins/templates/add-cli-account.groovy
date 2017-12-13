// These are the basic imports that Jenkin's interactive script console
// automatically includes.
import jenkins.*;
import jenkins.model.*;
import hudson.*;
import hudson.model.*;

def username = '{{ account_username }}'
def password = '{{ account_password }}'
def email = '{{ account_email }}'
def sshKey = '{{ account_ssh_key }}'

// Configure the security realm, which handles authentication.
def securityRealm = new hudson.security.HudsonPrivateSecurityRealm(false)
if(!securityRealm.equals(Jenkins.instance.getSecurityRealm())) {
  Jenkins.instance.setSecurityRealm(securityRealm)

  // Create a user to login with. Ensure that user is bound to the
  // system-local `jenkins` user's SSH key, to ensure that this
  // account can be used with Jenkins' CLI.
  def testUser = securityRealm.createAccount(username, password)
  testUser.addProperty(new hudson.tasks.Mailer.UserProperty(email));
  testUser.addProperty(new org.jenkinsci.main.modules.cli.auth.ssh.UserPropertyImpl(sshKey))
  testUser.save()

  Jenkins.instance.save()
  println "Changed authentication."
}
