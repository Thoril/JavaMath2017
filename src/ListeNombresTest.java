import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.logging.Level;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListeNombresTest {

    @Test
   public void FFTconstante() {
        double[] liste = new double[8];
        for(int i= 0; i<liste.length; i++){
            liste[i] = 1;
        }
        ListeNombres maListe = new ListeNombres(liste.length, liste);
        maListe.FFT();
        double res[]={8,0,0,0,0,0,0,0};
        for (int i=0; i<liste.length; i++ ){
            assertEquals(res[i], maListe.getSortieFourier(i), Math.pow(10, -5)); //Precision a 10^-5
        }

    }

    @Test
    public void FFTdirac() {
        double[] liste = new double[8];
        for(int i= 0; i<liste.length; i++){
            liste[i] = 0;
        }
        liste[0] = 1;
        ListeNombres maListe = new ListeNombres(liste.length, liste);
        maListe.FFT();
        double res[]={1,1,1,1,1,1,1,1};

        for (int i=0; i<liste.length; i++ ){
            assertEquals(res[i], maListe.getSortieFourier(i), Math.pow(10, -5)); //Precision a 10^-5
        }

    }

    @Test
    public void iFFTconstante(){
        double[] tab = new double[8];
        for(int i = 0; i<tab.length; i++){
            tab[i] = 1;
        }

        ListeNombres liste = new ListeNombres(8,tab);
        liste.iFFT();
        double res[]={1,1,1,1,1,1,1,1};

        for(int i = 0; i<tab.length; i++){
            assertEquals(res[i], liste.getSignalRetour(i), Math.pow(10, -5));
        }
    }

    @Test
    public void iFFTdirac(){
        double[] tab = new double[8];
        for(int i = 0; i < tab.length; i++){
            tab[i] = 0;
        }

        tab[0] = 1;
        ListeNombres liste = new ListeNombres(8,tab);
        liste.iFFT();

        double res[]={1,0,0,0,0,0,0,0,0};

        for(int i = 0; i<tab.length; i++){
            assertEquals(res[i], liste.getSignalRetour(i), Math.pow(10, -5));
        }

    }



}

