// These are the basic imports that Jenkin's interactive script console
// automatically includes.
import jenkins.*;
import jenkins.model.*;
import hudson.*;
import hudson.model.*;
import hudson.tasks.Mailer;

def username = '{{ account_username }}'
def password = '{{ account_password }}'
def email = '{{ account_email }}'

def jenkinsUser = Jenkins.instance.getSecurityRealm().allUsers.find {it.id == username}
if(jenkinsUser == null) {
  jenkinsUser = Jenkins.instance.getSecurityRealm().createAccount(username, password)
}
// TODO: need to remove old email address ?
jenkinsUser.addProperty(new Mailer.UserProperty(email));
