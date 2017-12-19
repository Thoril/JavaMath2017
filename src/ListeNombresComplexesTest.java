import org.junit.jupiter.api.Test;
import org.junit.*;

class ListeNombresComplexesTest {
    @Test
    void FFT() {
        NombreComplexe[] liste = new NombreComplexe[8];
        for(int i= 0; i<8; i++){
            liste[i] = new NombreComplexe(1, 0);
        }

        ListeNombresComplexes maListe = new ListeNombresComplexes(8, liste);
        maListe.FFT();
        System.out.printf("Resu \n");
        for(int i= 0; i<8; i++){
            maListe.getSortie(i).affiche();
        }

    }

    @Test
    public void iFFT(){

        NombreComplexe[] tab = new NombreComplexe[8];
        for(int i= 0; i<8; i++){
            tab[i] = new NombreComplexe(1, 0);
        }

        ListeNombresComplexesTest liste = new ListeNombresComplexes(3,tab);
        liste.FFT();
        liste.iFFT();

        System.out.printf("Resu \n");
        for(int i= 0; i<8; i++){
            liste.getSortie(i).affiche();
        }


    }

}