package Entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AVeloTest {

    @Test
    public void testGetNom() {
        AVelo velo = new AVelo();
        AVelo velo2 = new AVelo("Sortie dans l'après midi", 120, 11000, 188, 1, LocalDate.of(1989, 6, 4), 0, 0);

        assertNull(velo.getNom());
        assertEquals("Sortie dans l'après midi", velo2.getNom());
    }

    @Test
    public void testGetDuree() {
        AVelo velo = new AVelo();
        AVelo velo2 = new AVelo("Sortie dans l'après midi", 120, 11000, 188, 1, LocalDate.of(1989, 6, 4), 0, 0);

        assertEquals(0, velo.getDuree());
        assertEquals(120, velo2.getDuree());
    }

    @Test
    public void testGetDistance() {
        AVelo velo = new AVelo();
        AVelo velo2 = new AVelo("Sortie dans l'après midi", 120, 11000, 188, 1, LocalDate.of(1989, 6, 4), 0, 0);

        assertEquals(0, velo.getDistance());
        assertEquals(11000, velo2.getDistance());
    }

    @Test
    public void testSetNom() {
        AVelo velo = new AVelo();

        velo.setNom("Sortie");
        assertEquals("Sortie", velo.getNom());
    }

    @Test
    public void testGetId() {
        AVelo velo = new AVelo();
        AVelo velo2 = new AVelo("Sortie dans l'après midi", 120, 11000, 188, 1, LocalDate.of(1989, 6, 4), 0, 0);

        assertEquals(0, velo.getId());
        assertEquals(1, velo2.getId());
    }

    @Test
    public void testGetDate() {
        AVelo velo = new AVelo();
        AVelo velo2 = new AVelo("Sortie dans l'après midi", 120, 11000, 188, 1, LocalDate.of(1989, 6, 4), 0, 0);

        assertEquals(LocalDate.now(), velo.getDate());
        assertEquals(LocalDate.of(1989, 6, 4), velo2.getDate());
    }

    @Test
    public void testEquals() {
        AVelo velo = new AVelo();
        AVelo velo2 = new AVelo("Sortie dans l'après midi", 120, 11000, 188, 1, LocalDate.of(1989, 6, 4), 0, 0);
        AVelo velo3 = new AVelo("Sortie dans l'après midi", 120, 11000, 188, 1, LocalDate.of(1989, 6, 4), 0, 0);

        assertEquals(velo, velo);
        assertNotEquals(velo, velo2);
        assertNotEquals(velo, velo3);
        assertEquals(velo2, velo3);
    }
    

    @Test
    public void testToString() {
        AVelo velo = new AVelo("Sortie dans l'après midi", 120, 11000, 188, 1, LocalDate.of(1989, 6, 4), 0, 0);

        assertEquals("AVelo{id= 1, nom= Sortie dans l'après midi, duree= 120, date= 1989-06-04, distance= 11000, watt= 188}", velo.toString());
    }

    @Test
    void testGetWatt() {
        AVelo velo = new AVelo();
        AVelo velo2 = new AVelo("Sortie dans l'après midi", 120, 11000, 188, 1, LocalDate.of(1989, 6, 4), 0, 0);

        assertEquals(0, velo.getWatt());
        assertEquals(188, velo2.getWatt());
    }
}