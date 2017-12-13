import jenkins.*;
import jenkins.model.*;
import hudson.*;
import hudson.model.*;

// Configure the authorization strategy, which specifies who can do
// what.
def authorizationStrategy = new hudson.security.ProjectMatrixAuthorizationStrategy()
if(!authorizationStrategy.equals(Jenkins.instance.getAuthorizationStrategy())) {
  Jenkins.instance.setAuthorizationStrategy(authorizationStrategy)
  Jenkins.instance.save()
  println "Changed authorization."
}
