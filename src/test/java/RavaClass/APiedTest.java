package RavaClass;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class APiedTest {

    @Test
    public void testGetNom() {
        APied pied = new APied();
        APied pied2 = new APied("Sortie dans l'après midi", 120, 11000, 16069, 1, LocalDate.of(1989, 6, 4));

        assertNull(pied.getNom());
        assertEquals("Sortie dans l'après midi", pied2.getNom());
    }

    @Test
    public void testGetDuree() {
        APied pied = new APied();
        APied pied2 = new APied("Sortie dans l'après midi", 120, 11000, 16069, 1, LocalDate.of(1989, 6, 4));

        assertEquals(0, pied.getDuree());
        assertEquals(120, pied2.getDuree());
    }

    @Test
    public void testGetDistance() {
        APied pied = new APied();
        APied pied2 = new APied("Sortie dans l'après midi", 120, 11000, 16069, 1, LocalDate.of(1989, 6, 4));

        assertEquals(0, pied.getDistance());
        assertEquals(11000, pied2.getDistance());
    }

    @Test
    public void testSetNom() {
        APied pied = new APied();

        pied.setNom("Sortie");
        assertEquals("Sortie", pied.getNom());
    }

    @Test
    public void testGetId() {
        APied pied = new APied();
        APied pied2 = new APied("Sortie dans l'après midi", 120, 11000, 16069, 1, LocalDate.of(1989, 6, 4));

        assertEquals(0, pied.getId());
        assertEquals(1, pied2.getId());
    }

    @Test
    public void testGetDate() {
        APied pied = new APied();
        APied pied2 = new APied("Sortie dans l'après midi", 120, 11000, 16069, 1, LocalDate.of(1989, 6, 4));

        assertEquals(LocalDate.now(), pied.getDate());
        assertEquals(LocalDate.of(1989, 6, 4), pied2.getDate());
    }

    @Test
    public void testEquals() {
        APied pied = new APied();
        APied pied2 = new APied("Sortie dans l'après midi", 120, 11000, 16069, 1, LocalDate.of(1989, 6, 4));
        APied pied3 = new APied("Sortie dans l'après midi", 120, 11000, 16069, 1, LocalDate.of(1989, 6, 4));

        assertEquals(pied, pied);
        assertNotEquals(pied, pied2);
        assertNotEquals(pied, pied3);
        assertEquals(pied2, pied3);
    }

    @Test
    public void testGetNbPas() {
        APied pied = new APied();
        APied pied2 = new APied("Sortie dans l'après midi", 120, 11000, 16069, 1, LocalDate.of(1989, 6, 4));

        assertEquals(0, pied.getNbPas());
        assertEquals(16069, pied2.getNbPas());
    }

    @Test
    public void testToString() {
        APied pied = new APied("Sortie dans l'après midi", 120, 11000, 16069, 1, LocalDate.of(1989, 6, 4));

        assertEquals("APied{id= 1, nom= Sortie dans l'après midi, duree= 120, date= 1989-06-04, distance= 11000, nbPas= 16069}", pied.toString());
    }
}