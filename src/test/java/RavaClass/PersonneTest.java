package RavaClass;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonneTest {
    @Test
    public void testGetNom() {
        Personne personne = new Personne();
        Personne personne2 = new Personne("Jost", "Florian", 12, 90, 'N');
        assertEquals("Doe", personne.getNom());
        assertEquals("Jost", personne2.getNom());
    }

    @Test
    public void testGetPrenom() {
        Personne personne = new Personne();
        Personne personne2 = new Personne("Jost", "Florian", 12, 90, 'N');
        assertEquals("John", personne.getPrenom());
        assertEquals("Florian", personne2.getPrenom());
    }

    @Test
    public void testGetAge() {
        Personne personne = new Personne();
        Personne personne2 = new Personne("Jost", "Florian", 12, 90, 'N');
        assertEquals(21, personne.getAge());
        assertEquals(12, personne2.getAge());
    }

    @Test
    public void testEquals() {
        Personne personne = new Personne();
        Personne personne2 = new Personne("Jost", "Florian", 12, 90, 'N');
        Personne personne3 = new Personne();
        assertEquals(personne, personne);
        assertEquals(personne, personne3);
        assertNotEquals(personne, personne2);
        assertNotEquals(null, personne);
    }

    @Test
    public void testGetWeight() {
        Personne personne = new Personne();
        Personne personne2 = new Personne("Jost", "Florian", 12, 90, 'N');

        assertEquals(90, personne2.getWeight());
        assertEquals(70, personne.getWeight());
    }

    @Test
    public void testGetSexe() {
        Personne personne = new Personne();
        Personne personne2 = new Personne("Jost", "Florian", 12, 90, 'N');

        assertEquals('M', personne.getSexe());
        assertEquals('N', personne2.getSexe());
    }

    @Test
    public void testSetAge() {
        Personne personne = new Personne();

        personne.setAge(12);
        assertEquals(12, personne.getAge());
    }

    @Test
    public void testSetWeight() {
        Personne personne = new Personne();

        personne.setWeight(12);
        assertEquals(12, personne.getWeight());
    }

    @Test
    public void testToString() {
        Personne personne = new Personne();

        assertEquals("Personne{nom= Doe, prenom= John, sexe= M, age= 21, weight= 70, photo= absente}", personne.toString());
    }

}