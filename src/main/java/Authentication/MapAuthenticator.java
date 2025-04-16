package Authentication;

import java.util.HashMap;
import java.util.Map;

public class MapAuthenticator extends Authenticator {

    final private Map<String, String> mapData = new HashMap<>();

    public MapAuthenticator() {

    }

    @Override
    protected boolean isLoginExists(String username) {
        return mapData.containsKey(username);
    }

    @Override
    protected String getPassword(String username) {
        return mapData.get(username);
    }

    public void addUser(String username, String password) {
       mapData.put(username, password);
   }
}