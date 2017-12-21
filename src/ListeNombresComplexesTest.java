import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ListeNombresComplexesTest {
    //Fonction qui test la transforme de Fourier d'une constante
    @Test
    void FFTconstante() {
        NombreComplexe[] liste = new NombreComplexe[8];
        for(int i= 0; i<liste.length; i++){
            //Initialisation du tableau avec les nombres complexes, partie réelle = 1, partie imaginaire = 0
            liste[i] = new NombreComplexe(1, 0);
        }
        //Liste des valeurs initialisées dans le tableau précédent utilisé pour appliquer la transformée de Fourier
        ListeNombresComplexes maListe = new ListeNombresComplexes(liste.length, liste);
        maListe.FFT();
        //Tableau de nombres complexes attendus après appel à la fonction FFT()
        double res[][]={{8,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0}};
        for (int i=0; i<liste.length; i++ ){
            //Teste si la valeur réelle attendu = la valeur réelle actuelle avec une précision à 10^-5
            assertEquals(res[i][0], maListe.getSortieFourier(i).getReel(), Math.pow(10, -5)); //Precision a 10^-5
            //Teste si la valeur imaginaire attendu = la valeur imaginaire actuelle avec une précision à 10^-5
            assertEquals(res[i][1], maListe.getSortieFourier(i).getImaginaire(), Math.pow(10, -5));
        }


    }

    //Fonction qui teste la transforme de Fourier d'un pic de dirac pour les nombres complexes
    @Test
    void FFTdirac() {
        NombreComplexe[] liste = new NombreComplexe[8];
        for(int i= 0; i<liste.length; i++){
            //Initialisation tableau avec nombre complexe, partie réelle = 0, partie imaginaire = 0
            liste[i] = new NombreComplexe(0, 0);
        }
        //Initialisation de la première valeur du tab avec partie réelle = 1, partie imaginaire = 0
        liste[0].setReel(1);
        //Liste des valeurs initialisées dans le tableau précédent utilisé pour appliquer la transformée de Fourier
        ListeNombresComplexes maListe = new ListeNombresComplexes(liste.length, liste);
        maListe.FFT();
        //Tableau de nombres complexes attendus après appel à la fonction FFT()
        double res[][]={{1,0},{1,0},{1,0},{1,0},{1,0},{1,0},{1,0},{1,0}};

        for (int i=0; i<liste.length; i++ ){
            //Teste si la valeur réelle attendu = la valeur réelle actuelle avec une précision à 10^-5
            assertEquals(res[i][0], maListe.getSortieFourier(i).getReel(), Math.pow(10, -5));
            //Teste si la valeur imaginaire attendu = la valeur imaginaire actuelle avec une précision à 10^-5
            assertEquals(res[i][1], maListe.getSortieFourier(i).getImaginaire(), Math.pow(10, -5));
        }

    }

    //Fonction qui teste la transforme de fourier d'un sinus pour des nombres complexes
    @Test
    public void FFTsinus(){
        NombreComplexe[] tab = new NombreComplexe[8];
        for(int i = 0; i< tab.length; i++){
            //Initialisation tableau avec nombre complexe, partie réel : sin(2PI*t*Fo/tailleTableau), partie imaginaire : 0
            tab[i] = new NombreComplexe(Math.sin(2*Math.PI*i/tab.length),0);
        }
        //Liste des valeurs initialisées dans le tableau précédent utilisé pour appliquer la transformée de Fourier
        ListeNombresComplexes liste = new ListeNombresComplexes(tab.length, tab);
        liste.FFT();
        //Tableau de nombres complexes attendus après appel à la fonction FFT()
        float[][] res = {{0,0},{0,-4},{0,0},{0,0},{0,0},{0,0},{0,0},{0,4}};
        for(int i = 0; i< tab.length; i++){
            //Teste si la valeur réelle attendu = la valeur réelle actuelle avec une précision à 10^-5
            assertEquals(res[i][0], liste.getSortieFourier(i).getReel(), Math.pow(10, -5));
            //Teste si la valeur imaginaire attendu = la valeur imaginaire actuelle avec une précision à 10^-5
            assertEquals(res[i][1], liste.getSortieFourier(i).getImaginaire(), Math.pow(10, -5));

        }

    }

    //Fonction qui teste la transforme de fourier d'un cosinus pour des nombres complexes
    @Test
    public void FFTcosinus(){
        NombreComplexe[] tab = new NombreComplexe[8];
        for(int i = 0; i< tab.length; i++){
            //Initialisation tableau avec nombre complexe, partie réel = cos(2PI*t*Fo/tailleTableau), partie imaginaire = 0
            tab[i] = new NombreComplexe(Math.cos(2*Math.PI*i/tab.length),0);
        }
        //Liste des valeurs initialisées dans le tableau précédent utilisé pour appliquer la transformée de Fourier
        ListeNombresComplexes liste = new ListeNombresComplexes(tab.length, tab);
        liste.FFT();
        //Tableau de nombres complexes attendus après appel à la fonction FFT()
        float[][] res = {{0,0},{4,0},{0,0},{0,0},{0,0},{0,0},{0,0},{4,0}};
        for(int i = 0; i< tab.length; i++){
            //Teste si la valeur réelle attendu = la valeur réelle actuelle avec une précision à 10^-5
            assertEquals(res[i][0], liste.getSortieFourier(i).getReel(), Math.pow(10, -5)); //Precision a 10^-5
            //Teste si la valeur imaginaire attendu = la valeur imaginaire actuelle avec une précision à 10^-5
            assertEquals(res[i][1], liste.getSortieFourier(i).getImaginaire(), Math.pow(10, -5));

        }

    }

    @Test
    public void FFTImaginaireExpo(){
        NombreComplexe tabExp[] = new NombreComplexe[8];
        for (int indice=0 ; indice<tabExp.length; indice++){
            tabExp[indice] = new NombreComplexe(Math.cos(Math.PI * 2 *indice/(tabExp.length)),Math.sin(Math.PI * 2 *indice/(tabExp.length)));
        }
        //Liste des valeurs initialisées dans le tableau précédent utilisé pour appliquer la transformée de Fourier
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

    //Fonction qui teste l'inverse de la transformée de Fourier avec une constante
    @Test
    public void iFFTconstante(){

        NombreComplexe[] tab = new NombreComplexe[8];
        for(int i= 0; i<tab.length; i++){
            //Initialisation du tableau avec les nombres complexes, partie réelle = 1, partie imaginaire = 0
            tab[i] = new NombreComplexe(1, 0);
        }
        //Liste des valeurs initialisées dans le tableau précédent utilisé pour appliquer l'inverse de la transformée de Fourier
        ListeNombresComplexes liste = new ListeNombresComplexes(tab.length,tab);
        liste.iFFT();
        //Tableau de nombres complexes attendus après appel à la fonction iFFT()
        double res[][]={{1,0},{1,0},{1,0},{1,0},{1,0},{1,0},{1,0},{1,0}};

        for (int i=0; i<tab.length; i++ ){
            //Teste si la valeur réelle attendu = la valeur réelle actuelle avec une précision à 10^-5
            assertEquals(res[i][0], liste.getSignalRetour(i).getReel(), Math.pow(10, -5));
            //Teste si la valeur imaginaire attendu = la valeur imaginaire actuelle avec une précision à 10^-5
            assertEquals(res[i][1], liste.getSignalRetour(i).getImaginaire(), Math.pow(10, -5));
        }
    }

    @Test
    public void iFFTImaginaireExpo(){

        NombreComplexe tabExp[] = new NombreComplexe[8];
        for (int indice=0 ; indice<tabExp.length; indice++){
            tabExp[indice] = new NombreComplexe(Math.cos(Math.PI * 2 *indice/(tabExp.length)),Math.sin(Math.PI * 2 *indice/(tabExp.length)));
        }
        //Liste des valeurs initialisées dans le tableau précédent utilisé pour appliquer l'inverse de la transformée de Fourier
        ListeNombresComplexes liste = new ListeNombresComplexes(tabExp.length,tabExp);
        liste.iFFT();
        //Tableau de nombres complexes attendus après appel à la fonction iFFT()
        double res[][]={{1,0},{0.707,0.707},{0,1},{-0.707,0.707},{-1,0},{-0.707,-0.707},{0,-1},{0.707,-0.707}};

        for (int i=0; i<tabExp.length; i++ ){
            //Teste si la valeur réelle attendu = la valeur réelle actuelle avec une précision à 10^-3
            assertEquals(res[i][0], liste.getSignalRetour(i).getReel(), Math.pow(10, -3));
            //Teste si la valeur imaginaire attendu = la valeur imaginaire actuelle avec une précision à 10^-3
            assertEquals(res[i][1], liste.getSignalRetour(i).getImaginaire(), Math.pow(10, -3));
        }
    }

    @Test
    public void iFFTDirac(){
        NombreComplexe[] tab = new NombreComplexe[8];
        for(int i= 0; i<tab.length; i++){
            //Initialisation du tableau avec les nombres complexes, partie réelle = 0, partie imaginaire = 0
            tab[i] = new NombreComplexe(0, 0);
        }
        //Initialisation de la première valeur du tab avec partie réelle = 1, partie imaginaire = 0
        tab[0].setReel(1);
        //Liste des valeurs initialisées dans le tableau précédent utilisé pour appliquer l'inverse de la transformée de Fourier
        ListeNombresComplexes liste = new ListeNombresComplexes(tab.length, tab);
        liste.iFFT();
        //Tableau de nombres complexes attendus après appel à la fonction iFFT()
        float res[][]={{1,0},{1,0},{1,0},{1,0},{1,0},{1,0},{1,0},{1,0}};

        for (int i=0; i<tab.length; i++ ){
            //Teste si la valeur réelle attendu = la valeur réelle actuelle avec une précision à 10^-5
            assertEquals(res[i][0], liste.getSortieFourier(i).getReel(), Math.pow(10, -5));
            //Teste si la valeur imaginaire attendu = la valeur imaginaire actuelle avec une précision à 10^-5
            assertEquals(res[i][1], liste.getSortieFourier(i).getImaginaire(), Math.pow(10, -5));
        }
    }

}