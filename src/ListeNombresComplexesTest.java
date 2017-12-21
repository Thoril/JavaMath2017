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
        double res[][]={{8,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0}};
        for (int i=0; i<liste.length; i++ ){
            assertEquals(res[i][0], maListe.getSortieFourier(i).getReel(), Math.pow(10, -5)); //Precision a 10^-5
            assertEquals(res[i][1], maListe.getSortieFourier(i).getImaginaire(), Math.pow(10, -5));
        }


    }

    @Test
    void FFT() {
        NombreComplexe[] liste = new NombreComplexe[8];
        for(int i= 0; i<liste.length; i++){
            liste[i] = new NombreComplexe(i, 0);
        }
        ListeNombresComplexes maListe = new ListeNombresComplexes(liste.length, liste);
        maListe.FFT();
        double res[][]={{8,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0}};
        for (int i=0; i<liste.length; i++ ){
            maListe.getSortieFourier(i).affiche();
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
        double res[][]={{1,0},{1,0},{1,0},{1,0},{1,0},{1,0},{1,0},{1,0}};

        for (int i=0; i<liste.length; i++ ){
            assertEquals(res[i][0], maListe.getSortieFourier(i).getReel(), Math.pow(10, -5)); //Precision a 10^-5
            assertEquals(res[i][1], maListe.getSortieFourier(i).getImaginaire(), Math.pow(10, -5));
        }

    }

    @Test
    public void FFTsinus(){
        NombreComplexe[] tab = new NombreComplexe[8];
        for(int i = 0; i< tab.length; i++){
            tab[i] = new NombreComplexe(Math.sin(2*Math.PI*i/tab.length),0);
            System.out.println("Les valeurs du sinus sont : "+tab[i]);
        }

        ListeNombresComplexes liste = new ListeNombresComplexes(tab.length, tab);
        liste.FFT();

        float[][] res = {{0,0},{0,-4},{0,0},{0,0},{0,0},{0,0},{0,0},{0,4}};
        for(int i = 0; i< tab.length; i++){
            System.out.println("Les valeurs de la fft sont : "+liste.getSortieFourier(i));
            assertEquals(res[i][0], liste.getSortieFourier(i).getReel(), Math.pow(10, -5)); //Precision a 10^-5
            assertEquals(res[i][1], liste.getSortieFourier(i).getImaginaire(), Math.pow(10, -5));

        }

    }

    @Test
    public void FFTcosinus(){
        NombreComplexe[] tab = new NombreComplexe[8];
        for(int i = 0; i< tab.length; i++){
            tab[i] = new NombreComplexe(Math.cos(2*Math.PI*i/tab.length),0);
            System.out.println("Les valeurs du cos sont : "+tab[i]);
        }

        ListeNombresComplexes liste = new ListeNombresComplexes(tab.length, tab);
        liste.FFT();

        float[][] res = {{0,0},{4,0},{0,0},{0,0},{0,0},{0,0},{0,0},{4,0}};
        for(int i = 0; i< tab.length; i++){
            System.out.println("Les valeurs de la fft sont : "+liste.getSortieFourier(i));
            assertEquals(res[i][0], liste.getSortieFourier(i).getReel(), Math.pow(10, -5)); //Precision a 10^-5
            assertEquals(res[i][1], liste.getSortieFourier(i).getImaginaire(), Math.pow(10, -5));

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
        double res[][]={{0,0},{8,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0}};
        maListe.iFFT();
        for(int i =0; i<tabExp.length;i++){
            maListe.getSignalRetour(i).affiche();
        }
        for (int i=0; i<tabExp.length; i++ ){
            assertEquals(res[i][0], maListe.getSortieFourier(i).getReel(), Math.pow(10, -5)); //Precision a 10^-5
            assertEquals(res[i][1], maListe.getSortieFourier(i).getImaginaire(), Math.pow(10, -5));
        }
    }

    @Test
    public void iFFTconstante(){

        NombreComplexe[] tab = new NombreComplexe[8];
        for(int i= 0; i<tab.length; i++){
            tab[i] = new NombreComplexe(1, 0);
        }
        ListeNombresComplexes liste = new ListeNombresComplexes(tab.length,tab);
        liste.iFFT();

        double res[][]={{1,0},{1,0},{1,0},{1,0},{1,0},{1,0},{1,0},{1,0}};

        for (int i=0; i<tab.length; i++ ){
            assertEquals(res[i][0], liste.getSignalRetour(i).getReel(), Math.pow(10, -5)); //Precision a 10^-5
            assertEquals(res[i][1], liste.getSignalRetour(i).getImaginaire(), Math.pow(10, -5));
        }
    }

    @Test
    public void iFFTImaginaireExpo(){

        NombreComplexe tabExp[] = new NombreComplexe[8];
        for (int indice=0 ; indice<tabExp.length; indice++){
            tabExp[indice] = new NombreComplexe(Math.cos(Math.PI * 2 *indice/(tabExp.length)),Math.sin(Math.PI * 2 *indice/(tabExp.length)));
        }
        ListeNombresComplexes liste = new ListeNombresComplexes(tabExp.length,tabExp);
        liste.iFFT();

        double res[][]={{1,0},{0.707,0.707},{0,1},{-0.707,0.707},{-1,0},{-0.707,-0.707},{0,-1},{0.707,-0.707}};

        for (int i=0; i<tabExp.length; i++ ){
            assertEquals(res[i][0], liste.getSignalRetour(i).getReel(), Math.pow(10, -3)); //Precision a 10^-3
            assertEquals(res[i][1], liste.getSignalRetour(i).getImaginaire(), Math.pow(10, -3));
        }
    }

    @Test
    public void iFFTDirac(){
        NombreComplexe[] tab = new NombreComplexe[8];
        for(int i= 0; i<tab.length; i++){
            tab[i] = new NombreComplexe(0, 0);
        }
        tab[0].setReel(1);
        ListeNombresComplexes liste = new ListeNombresComplexes(tab.length, tab);
        liste.iFFT();
        float res[][]={{1,0},{1,0},{1,0},{1,0},{1,0},{1,0},{1,0},{1,0}};

        for (int i=0; i<tab.length; i++ ){
            assertEquals(res[i][0], liste.getSortieFourier(i).getReel(), Math.pow(10, -5)); //Precision a 10^-5
            assertEquals(res[i][1], liste.getSortieFourier(i).getImaginaire(), Math.pow(10, -5));
        }
    }

}