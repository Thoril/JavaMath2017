import org.junit.jupiter.api.Test;

class ListeNombresComplexesTest {
    @Test
    void FFT() {
        NombreComplexe[] liste = new NombreComplexe[8];
        for(int i= 0; i<8; i++){
            liste[i] = new NombreComplexe(0, 0);
        }
        liste[0].setReel(1);
        ListeNombresComplexes maListe = new ListeNombresComplexes(8, liste);
        maListe.FFT();
        System.out.printf("Resu \n");
        for(int i= 0; i<8; i++){
            maListe.getSortieFourier(i).affiche();
        }

    }

    @Test
    public void iFFT(){

        NombreComplexe[] tab = new NombreComplexe[8];
        for(int i= 0; i<8; i++){
            tab[i] = new NombreComplexe(1, 0);
        }
        ListeNombresComplexes liste = new ListeNombresComplexes(8,tab);
        liste.iFFT();

        System.out.printf("Resu \n");
        for(int i= 0; i<8; i++){
            liste.getSignalRetour(i).affiche();
        }


    }

}