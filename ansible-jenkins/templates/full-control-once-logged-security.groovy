import jenkins.*;
import jenkins.model.*;
import hudson.*;
import hudson.model.*;

// Configure the authorization strategy, which specifies who can do
// what.
def authorizationStrategy = new hudson.security.FullControlOnceLoggedInAuthorizationStrategy()
if(!authorizationStrategy.equals(Jenkins.instance.getAuthorizationStrategy())) {
  authorizationStrategy.setAllowAnonymousRead(false)
  Jenkins.instance.setAuthorizationStrategy(authorizationStrategy)
  Jenkins.instance.save()
  println "Changed authorization."
}
