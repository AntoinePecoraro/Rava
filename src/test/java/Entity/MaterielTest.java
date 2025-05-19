package Entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaterielTest {

    @Test
    public void testGetMarque() {
        Materiel m = new Materiel();
        Materiel m2 = new Materiel("Orbea", "Orca M30", 0);
        assertNull(m.getMarque());
        assertEquals("Orbea", m2.getMarque());
    }

    @Test
    public void testSetMarque() {
        Materiel m = new Materiel();
        m.setMarque("Orbea");
        assertEquals("Orbea", m.getMarque());
    }

    @Test
    public void testGetModele() {
        Materiel m = new Materiel();
        Materiel m2 = new Materiel("Orbea", "Orca M30", 0);
        assertNull(m.getModele());
        assertEquals("Orca M30", m2.getModele());
    }

    @Test
    public void testSetModele() {
        Materiel m = new Materiel();
        m.setModele("Orca M30");
        assertEquals("Orca M30", m.getModele());
    }

    @Test
    public void testEquals() {
        Materiel m = new Materiel();
        Materiel m2 = new Materiel("Orbea", "Orca M30", 1);
        Materiel m3 = new Materiel("Orbea", "Orca M30", 1);

        assertEquals(m, m);
        assertNotEquals(m, m2);
        assertNotEquals(m, m3);
        assertEquals(m2, m3);
    }

    @Test
    public void testToString() {
        Materiel m = new Materiel("Orbea", "Orca M30", 0);
        assertEquals("Materiel{marque= Orbea, modele= Orca M30}", m.toString());
    }
}