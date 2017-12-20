import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListeNombresTest {

        @Test
        void FFT() {
            double[] liste = new double[8];
            for(int i= 0; i<8; i++){
                liste[i] = 0;
            }
            liste[0] = 1;
            ListeNombres maListe = new ListeNombres(8, liste);
            maListe.FFT();
            for(int i= 0; i<8; i++){
                assertEquals(maListe.getSortieFourier(i), 1, Math.pow(10,-5));
            }

        }

        @Test
        public void iFFT(){

            double[] tab = new double[8];
            for(int i= 0; i<8; i++){
                tab[i] = 1;
            }
            ListeNombres liste = new ListeNombres(8,tab);
            liste.iFFT();

            for(int i= 0; i<8; i++){
                assertEquals(liste.getSignalRetour(i), 1, Math.pow(10,-5));
            }
        }
}

