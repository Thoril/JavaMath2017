import java.util.Observable;

public class ListeNombresComplexes extends Observable{

    private int taille;
    private NombreComplexe[] signalEntree;
    private NombreComplexe[] sortieFourier;
    private NombreComplexe[] signalRetour;

    /**
     * Récupère un signal d'entree d'un tableau de nombre complexe
     * @return signalEntree
     */
    public NombreComplexe[] getSignalEntree() {
        return signalEntree;
    }

    /**
     * Récupère un signal de sortie sous la forme d'un tableau de nombre complexe
     * @return sortieFourier
     */
    public NombreComplexe[] getSortieFourier() {
        return sortieFourier;
    }

    /**
     * Récupère un signal de retour sous la forme d'un tableau de nombre complexe
     * @return signalRetour
     */
    public NombreComplexe[] getSignalRetour() {
        return signalRetour;
    }


    /**
     * Controleur de la classe
     * @param taille
     * @param signal
     */
    public ListeNombresComplexes(int taille, NombreComplexe[] signal) {
        if(taille<0 || (taille%2 != 0 && taille != 1)){
            throw new IllegalStateException(" Taille non valide ");
        }
        if(signal.length != taille){
            throw new IllegalStateException(" La taille ne correspond pas au tableau ");
        }
        this.taille = taille;
        this.signalEntree = signal;
    }

    /**
     * Récupère la taille
     * @return taille
     */
    public int getTaille() {
        return taille;
    }

    /**
     * Initialise la taille
     * @param taille
     */
    public void setTaille(int taille) {
        this.taille = taille;
    }

    /**
     * Récupère un signal d'entree
     * @param indice
     * @return signalEntree[indice]
     */
    public NombreComplexe getSignalEntree(int indice) {
        return signalEntree[indice];
    }

    /**
     * Initialise un signal d'entree
     * @param signalEntree
     */
    public void setSignalEntree(NombreComplexe[] signalEntree) {
        this.signalEntree = signalEntree;
    }

    /**
     * Récupère la sortie d'un signal de Fourier
     * @param indice
     * @return sortieFourier[indice]
     */
    public NombreComplexe getSortieFourier(int indice) {
        return sortieFourier[indice];
    }

    /**
     * Récupère la sortie d'un signal retour
     * @param indice
     * @return signalRetour[indice]
     */
    public NombreComplexe getSignalRetour(int indice) {
        return signalRetour[indice];
    }

    /**
     * Calcule la transformée de Fourier d'un tableau de nombre complexe
     */
    public void FFT(){
        this.sortieFourier = new NombreComplexe[this.taille];
        //si la liste est de taille 1
        if(this.taille==1){
            //On copie le signal dans S
            this.sortieFourier[0] = this.signalEntree[0];
        }else{ //sinon on redivise la liste
            NombreComplexe[] tabPaire = new NombreComplexe[this.taille/2];   //On declare la liste des éléments paires
            NombreComplexe[] tabImpaire = new NombreComplexe[this.taille/2];  //On declare la liste des éléments impaires
            //On crée les 2 listes a partir de la liste principale
            for(int i=0;i<this.taille/2;i++){
                tabPaire[i]=this.signalEntree[2*i];
                tabImpaire[i]=this.signalEntree[2*i+1];
            }
            //On initialise les deux objets qui continent les listes
            ListeNombresComplexes paire = new ListeNombresComplexes(this.taille/2, tabPaire);
            ListeNombresComplexes impaire = new ListeNombresComplexes(this.taille /2, tabImpaire);
            //On calcule la FFT des deux listes
            paire.FFT();
            impaire.FFT();
            //On initialise notre multiplicateur
            for(int i=0;i<this.taille/2;i++ ){
                //On incremente le multiplicateur
                double m = -2*Math.PI*i/this.taille;
                NombreComplexe multi =  new NombreComplexe(Math.cos(m),Math.sin(m));
                //Notre liste de retour prend la valeur de la liste paire pour la premiere moitié
                this.sortieFourier[i] = (paire.getSortieFourier(i)).plus((impaire.getSortieFourier(i)).fois(multi));
                //Et la valeur de la liste impaire pour la seconde moitié
                this.sortieFourier[i+this.taille/2] = (paire.getSortieFourier(i)).moins((impaire.getSortieFourier(i)).fois(multi));
            }
        }
        this.notifyObservers();
    }

    /**
     * Calcule l'inverse de la transformée de Fourier d'un tableau de nombres complexes
     */
    public void iFFT() {

        //Verification si la sortie de Fourier est déja existante
        if(this.sortieFourier == null){
            this.FFT();
        }
        //Création d'un tableau de taille taille
        this.signalRetour = new NombreComplexe[this.taille];

        //Calcul du conjugué pour toutes les valeurs du tableau
        for(int i=0; i<this.taille; i++){
            this.signalRetour[i] = this.sortieFourier[i].conjugue();
        }

        ListeNombresComplexes maListe = new ListeNombresComplexes(this.taille , this.signalRetour);
        // Calcul de la transformée de fourier du tableau
        maListe.FFT();

        //Calcul du conjugué pour les nouvelles valeurs
        for(int i=0; i < this.taille; i++){
            this.signalRetour[i] = (maListe.getSortieFourier(i)).conjugue();
        }

        //Initialisation d'une multiplicateur avec la partie réel = 1/n et img =0
        NombreComplexe multi =  new NombreComplexe(1.0/this.taille, 0);

        //On multiplie chaque valeurs du tableau par 1/n car dans la transformée de fourier on multiplie par la taille du tableau (n)
        for(int i=0; i < this.taille; i++){
           this.signalRetour[i] = this.signalRetour[i].fois(multi);
        }
        this.notifyObservers();
    }
    /**
     * Notifie les observeurs
     */
    @Override
    public void notifyObservers() {
        setChanged(); // Set the changed flag to true, otherwise observers won't be notified.
        super.notifyObservers();
    }

}
