package Authentication;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapAuthenticatorTest {

    @Test
    void addUser() {
        MapAuthenticator authenticator = new MapAuthenticator();
        authenticator.addUser("test", "test");
        assertEquals("test", authenticator.getPassword("test"));
    }

    @Test
    void isLoginExists() {
        MapAuthenticator authenticator = new MapAuthenticator();
        authenticator.addUser("test", "test");
        assertTrue(authenticator.isLoginExists("test"));
        assertFalse(authenticator.isLoginExists("test2"));
    }

    @Test
    void getPassword() {
        MapAuthenticator authenticator = new MapAuthenticator();
        authenticator.addUser("test", "test");
        assertEquals("test", authenticator.getPassword("test"));
        assertNull(authenticator.getPassword("test2"));
    }


}