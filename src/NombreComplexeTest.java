import static org.junit.jupiter.api.Assertions.assertTrue;

class NombreComplexeTest {
    @org.junit.jupiter.api.Test
    void getReelle() {
        NombreComplexe a = new NombreComplexe(3,4);
        assertTrue(a.getReel() == 3, "Erreur Récuperation partie réelle");
    }

    @org.junit.jupiter.api.Test
    void setReel() {
        NombreComplexe a = new NombreComplexe(3,4);
        a.setReel(8);
        assertTrue(a.getReel() == 8, "Erreur Affectation partie réelle");
    }

    @org.junit.jupiter.api.Test
    void getImaginaire() {
        NombreComplexe a = new NombreComplexe(3,4);
        assertTrue(a.getImaginaire() == 4, "Erreur Récuperation partie Imaginaire");
    }

    @org.junit.jupiter.api.Test
    void setImaginaire() {
        NombreComplexe a = new NombreComplexe(3,4);
        a.setImaginaire(6);
        assertTrue(a.getImaginaire() == 6, "Erreur Affectation partie Imaginaire");

    }

    @org.junit.jupiter.api.Test
    void plus() {
        NombreComplexe a = new NombreComplexe(3,4);
        NombreComplexe b = new NombreComplexe( 2, 6 );
        NombreComplexe r = a.plus(b);
        assertTrue( r.getReel() == 5 && r.getImaginaire() == 10, "Erreur Addition Complexe");
    }

    @org.junit.jupiter.api.Test
    void moins() {
        NombreComplexe a = new NombreComplexe(3,4);
        NombreComplexe b = new NombreComplexe( 2, 6 );
        NombreComplexe r = a.moins(b);
        assertTrue(r.getReel() == 1 && r.getImaginaire() == -2, "Erreur Soustraction Complexe");
    }

    @org.junit.jupiter.api.Test
    void fois() {
        NombreComplexe a = new NombreComplexe(3,4);
        NombreComplexe b = new NombreComplexe( 2, 6 );
        NombreComplexe r = a.fois(b);
        assertTrue(r.getReel() == -18 && r.getImaginaire() == 26, "Erreur Multiplication Complexe");
    }

}