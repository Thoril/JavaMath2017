import org.junit.jupiter.api.Test;

class ListeNombresComplexesTest {
    @Test
    void FFT() {
        NombreComplexe[] liste = new NombreComplexe[8];
        for(int i= 0; i<8; i++){
            liste[i] = new NombreComplexe(i, 0);
        }
        ListeNombresComplexes maListe = new ListeNombresComplexes(8, liste);
        NombreComplexe[] retour = maListe.FFT();
        for(int i= 0; i<8; i++){
            retour[i].affiche();
        }

    }

}