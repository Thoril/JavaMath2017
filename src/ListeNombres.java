public class ListeNombres {


    private int taille;
    private double[] signalEntree;
    private double[] sortieFourier;
    private double[] signalRetour;

    public ListeNombres(int taille, double[] signal) {
        if(taille<0 ||( taille%2 != 0 && taille != 1 )){
            throw new IllegalStateException(" Taille non valide ");
        }
        if(signal.length != taille){
            throw new IllegalStateException(" La taille ne correspond pas au tableau ");
        }
        this.taille = taille;
        this.signalEntree = signal;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public double getSignalEntree(int indice) {
        return signalEntree[indice];
    }

    public void setSignalEntree(double[] signalEntree) {
        this.signalEntree = signalEntree;
    }

    public double getSortieFourier(int indice) {
        return sortieFourier[indice];
    }

    public double getSignalRetour(int indice) {
        return signalRetour[indice];
    }

    public void FFT(){
        this.sortieFourier = new double[this.taille];
        //si la liste est de taille 1
        if(this.taille==1){
            //On copie le signal dans S
            this.sortieFourier[0] = this.signalEntree[0];
        }else{ //sinon on redivise la liste
            double[] tabPaire = new double[this.taille/2];   //On declare la liste des éléments paires
            double[] tabImpaire = new double[this.taille/2];  //On declare la liste des éléments impaires
            //On crée les 2 listes a partir de la liste principale
            for(int i=0;i<this.taille/2;i++){
                tabPaire[i]=this.signalEntree[2*i];
                tabImpaire[i]=this.signalEntree[2*i+1];
            }
            //On initialise les deux objets qui continent les listes
            ListeNombres paire = new ListeNombres(this.taille/2, tabPaire);
            ListeNombres impaire = new ListeNombres(this.taille /2, tabImpaire);
            //On calcule la FFT des deux listes
            paire.FFT();
            impaire.FFT();
            //On initialise notre multiplicateur
            for(int i=0;i<this.taille/2;i++ ){
                //On incremente le multiplicateur
                double m = -2*Math.PI*i/this.taille;
                double multi =  Math.cos(m);
                //Notre liste de retour prend la valeur de la liste paire pour la premiere moitié
                this.sortieFourier[i] = (paire.getSortieFourier(i))+((impaire.getSortieFourier(i))*(multi));
                //Et la valeur de la liste impaire pour la seconde moitié
                this.sortieFourier[i+this.taille/2] = (paire.getSortieFourier(i))-((impaire.getSortieFourier(i))*(multi));
            }
        }
    }

    public void iFFT() {

        //Verification si la sortie de Fourier est déja existante
        if(this.sortieFourier == null){
            this.FFT();
        }
        //Création d'un tableau de taille taille
        this.signalRetour = new double[this.taille];

        //Calcul du conjugué pour toutes les valeurs du tableau
        for(int i=0; i<this.taille; i++){
            this.signalRetour[i] = this.sortieFourier[i];
        }

        ListeNombres maListe = new ListeNombres(this.taille , this.signalRetour);
        // Calcul de la transformée de fourier du tableau
        maListe.FFT();

        //Calcul du conjugué pour les nouvelles valeurs
        for(int i=0; i < this.taille; i++){
            this.signalRetour[i] = (maListe.getSortieFourier(i));
        }

        //Initialisation d'une multiplicateur avec la partie réel = 1/n et img =0
        double multi =  1.0/this.taille;

        //On multiplie chaque valeurs du tableau par 1/n car dans la transformée de fourier on multiplie par la taille du tableau (n)
        for(int i=0; i < this.taille; i++){
            this.signalRetour[i] = this.signalRetour[i]*(multi);
        }
    }

}
