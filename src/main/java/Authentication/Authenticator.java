package Authentication;

public abstract class Authenticator {
    public boolean authenticate(String username, String password) {
        return isLoginExist(username) && getPassword(username).equals(password);
    }

    protected abstract boolean isLoginExist(String username);

    protected abstract String getPassword(String username);
}
