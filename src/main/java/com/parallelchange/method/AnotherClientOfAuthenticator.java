package main.java.com.parallelchange.method;

public class AnotherClientOfAuthenticator {
    public void unusedClientCode() {
        try {
            new AuthenticationService().isAuthenticated(3545);
        } catch (Exception e) {
            // ignored
        }
    }
}