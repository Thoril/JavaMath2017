import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ListeNombresComplexesTest {
    @Test
    void FFTconstante() {
        NombreComplexe[] liste = new NombreComplexe[8];
        for(int i= 0; i<liste.length; i++){
            liste[i] = new NombreComplexe(1, 0);
        }
        ListeNombresComplexes maListe = new ListeNombresComplexes(liste.length, liste);
        maListe.FFT();
        float res[][]={{8,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0}};
        for (int i=0; i<liste.length; i++ ){
            assertEquals(res[i][0], maListe.getSortieFourier(i).getReel(), Math.pow(10, -5)); //Precision a 10^-5
            assertEquals(res[i][1], maListe.getSortieFourier(i).getImaginaire(), Math.pow(10, -5));
        }

    }
    @Test
    void FFTdirac() {
        NombreComplexe[] liste = new NombreComplexe[8];
        for(int i= 0; i<liste.length; i++){
            liste[i] = new NombreComplexe(0, 0);
        }
        liste[0].setReel(1);
        ListeNombresComplexes maListe = new ListeNombresComplexes(liste.length, liste);
        maListe.FFT();
        float res[][]={{1,0},{1,0},{1,0},{1,0},{1,0},{1,0},{1,0},{1,0}};

        for (int i=0; i<liste.length; i++ ){
            assertEquals(res[i][0], maListe.getSortieFourier(i).getReel(), Math.pow(10, -5)); //Precision a 10^-5
            assertEquals(res[i][1], maListe.getSortieFourier(i).getImaginaire(), Math.pow(10, -5));
        }

    }

    @Test
    public void FFTImaginaireExpo(){
        NombreComplexe tabExp[] = new NombreComplexe[8];
        for (int indice=0 ; indice<tabExp.length; indice++){
            tabExp[indice] = new NombreComplexe(Math.cos(Math.PI * 2 *indice/(tabExp.length)),Math.sin(Math.PI * 2 *indice/(tabExp.length)));
        }
        ListeNombresComplexes maListe = new ListeNombresComplexes(tabExp.length,tabExp);
        maListe.FFT();
        float res[][]={{0,0},{8,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0}};

        for (int i=0; i<tabExp.length; i++ ){
            assertEquals(res[i][0], maListe.getSortieFourier(i).getReel(), Math.pow(10, -5)); //Precision a 10^-5
            assertEquals(res[i][1], maListe.getSortieFourier(i).getImaginaire(), Math.pow(10, -5));
        }
    }

    @Test
    public void iFFT(){

        NombreComplexe[] tab = new NombreComplexe[8];
        for(int i= 0; i<tab.length; i++){
            tab[i] = new NombreComplexe(1, 0);
        }
        ListeNombresComplexes liste = new ListeNombresComplexes(tab.length,tab);
        liste.iFFT();

        float res[][]={{1,0},{1,0},{1,0},{1,0},{1,0},{1,0},{1,0},{1,0}};

        for (int i=0; i<tab.length; i++ ){
            assertEquals(res[i][0], liste.getSignalRetour(i).getReel(), Math.pow(10, -5)); //Precision a 10^-5
            assertEquals(res[i][1], liste.getSignalRetour(i).getImaginaire(), Math.pow(10, -5));
        }
    }

}