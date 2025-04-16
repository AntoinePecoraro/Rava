package Authentication;

public abstract class Authenticator {
    public boolean authenticate(String username, String password) {
        return isLoginExists(username) && getPassword(username).equals(password);
    }

    protected abstract boolean isLoginExists(String username);

    protected abstract String getPassword(String username);
}
