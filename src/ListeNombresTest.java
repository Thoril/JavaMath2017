import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.logging.Level;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListeNombresTest {

    //Fonction qui teste la transformée de Fourier d'une constante pour des réels
    @Test
   public void FFTconstante() {
        double[] liste = new double[8];
        for(int i= 0; i<liste.length; i++){
            //Initialisation du tableau de réels à 1
            liste[i] = 1;
        }

        //Liste des valeurs initialisées dans le tableau précédent utilisé pour appliquer la transformée de Fourier
        ListeNombres maListe = new ListeNombres(liste.length, liste);
        maListe.FFT();
        //Tableau de nombres réels attendu après l'appel à la fonction FFT()
        double res[]={8,0,0,0,0,0,0,0};
        for (int i=0; i<liste.length; i++ ){
            //Teste si la valeur attendu = la valeur actuelle avec une précision à 10^-5
            assertEquals(res[i], maListe.getSortieFourier(i), Math.pow(10, -5)); //Precision a 10^-5
        }
    }

    //Fonction qui teste la transformée de Fourier d'un pic de dirac pour des réels
    @Test
    public void FFTdirac() {
        double[] liste = new double[8];
        for(int i= 0; i<liste.length; i++){
            //Initialisation du tableau de réels à 0
            liste[i] = 0;
        }
        //Initialisation de la première valeur du tableau à 1 représentant le pic
        liste[0] = 1;
        //Liste des valeurs initialisées dans le tableau précédent utilisé pour appliquer la transformée de Fourier
        ListeNombres maListe = new ListeNombres(liste.length, liste);
        maListe.FFT();
        //Tableau de nombres réels attendu après l'appel à la fonction FFT()
        double res[]={1,1,1,1,1,1,1,1};

        for (int i=0; i<liste.length; i++ ){
            //Teste si la valeur attendu = la valeur actuelle avec une précision à 10^-5
            assertEquals(res[i], maListe.getSortieFourier(i), Math.pow(10, -5)); //Precision a 10^-5
        }

    }

    //Fonction qui teste l'inverse de la transformée de Fourier d'une constante pour des réels
    @Test
    public void iFFTconstante(){
        double[] tab = new double[8];
        for(int i = 0; i<tab.length; i++){
            //Initialisation du tableau de réels à 1
            tab[i] = 1;
        }
        //Liste des valeurs initialisées dans le tableau précédent utilisé pour appliquer l'inverse de la transformée de Fourier
        ListeNombres liste = new ListeNombres(8,tab);
        liste.iFFT();
        //Tableau de nombres réels attendu après l'appel à la fonction iFFT()
        double res[]={1,1,1,1,1,1,1,1};

        for(int i = 0; i<tab.length; i++){
            //Teste si la valeur attendu = la valeur actuelle avec une précision à 10^-5
            assertEquals(res[i], liste.getSignalRetour(i), Math.pow(10, -5));
        }
    }

    //Fonction qui teste l'inverse de la transformée de Fourier d'un pic de dirac pour des réels
    @Test
    public void iFFTdirac(){
        double[] tab = new double[8];
        for(int i = 0; i < tab.length; i++){
            //Initialisation du tableau de réels à 0
            tab[i] = 0;
        }
        //Initialisation de la première valeur du tableau à 1 représentant le pic
        tab[0] = 1;
        //Liste des valeurs initialisées dans le tableau précédent utilisé pour appliquer l'inverse de la transformée de Fourier
        ListeNombres liste = new ListeNombres(8,tab);
        liste.iFFT();
        //Tableau de nombres réels attendu après l'appel à la fonction iFFT()
        double res[]={1,0,0,0,0,0,0,0,0};

        for(int i = 0; i<tab.length; i++){
            //Teste si la valeur attendu = la valeur actuelle avec une précision à 10^-5
            assertEquals(res[i], liste.getSignalRetour(i), Math.pow(10, -5));
        }

    }



}

