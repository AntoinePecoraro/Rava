package Entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonneTest {
    @Test
    public void testGetNom() {
        Personne personne = new Personne();
        Personne personne2 = new Personne("Jost", "Florian", "JoFlo", 'N', 1);
        assertEquals("Doe", personne.getNom());
        assertEquals("Jost", personne2.getNom());
    }

    @Test
    public void testGetPrenom() {
        Personne personne = new Personne();
        Personne personne2 = new Personne("Jost", "Florian", "JoFlo", 'N', 1);
        assertEquals("John", personne.getPrenom());
        assertEquals("Florian", personne2.getPrenom());
    }

    @Test
    public void testEquals() {
        Personne personne = new Personne();
        Personne personne2 = new Personne("Jost", "Florian", "JoFlo", 'N', 1);
        Personne personne3 = new Personne();
        assertEquals(personne, personne);
        assertEquals(personne, personne3);
        assertNotEquals(personne, personne2);
        assertNotEquals(null, personne);
    }

    @Test
    public void testGetSexe() {
        Personne personne = new Personne();
        Personne personne2 = new Personne("Jost", "Florian", "JoFlo", 'N', 1);

        assertEquals('M', personne.getSexe());
        assertEquals('N', personne2.getSexe());
    }

    @Test
    public void testToString() {
        Personne personne = new Personne();

        assertEquals("Personne{nom= Doe, prenom= John, sexe= M, age= 21, weight= 70, photo= absente}", personne.toString());
    }

}