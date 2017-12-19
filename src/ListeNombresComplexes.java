public class ListeNombresComplexes {

    private int taille;
    private NombreComplexe[] signalEntree;

    public NombreComplexe getSignalEntree(int indice) {
        return signalEntree[indice];
    }

    public void setSignalEntree(NombreComplexe[] signalEntree) {
        this.signalEntree = signalEntree;
    }

    public NombreComplexe getSortie(int indice) {
        return sortie[indice];
    }

    private NombreComplexe[] sortie;

    public ListeNombresComplexes(int taille, NombreComplexe[] signal) {
        this.taille = taille;
        this.signalEntree = signal;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public void FFT(){
        this.sortie = new NombreComplexe[this.taille];
        //si la liste est de taille 1
        if(this.taille==1){
            //On copie le signal dans S
            this.sortie[0] = this.signalEntree[0];
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
                this.sortie[i] = (paire.getSortie(i)).plus((impaire.getSortie(i)).fois(multi));
                //Et la valeur de la liste impaire pour la seconde moitié
                this.sortie[i+this.taille/2] = (paire.getSortie(i)).moins((impaire.getSortie(i)).fois(multi));
            }
        }
    }

    public void iFFT() {
        //Création d'un tableau de taille taille
        this.sortie = new NombreComplexe[this.taille];

        //Calcul du conjugué pour toutes les valeurs du tableau
        for(int i=0; i<this.taille; i++){
            this.sortie[i] = this.signalEntree[i].conjugue();
        }

        // Calcul de la transformée de fourier du tableau
        this.sortie.FFT();

        Calcul du conjugué pour les nouvelles valeurs
        for(int i=0; i < n; i++){
            this.sortie[i] = this.sortie[i].conjugue();
        }

        //Initialisation d'une multiplicateur avec la partie réel = n et img =0
        NombreComplexe multi =  new NombreComplexe(n, 0);

        //On divise chaque valeurs du tableau par 1/n car dans la transformée de fourier on multiplie par la taille du tableau
        for(int i=0; i < n; i++){
            this.sortie[i].fois(1/multi);
        }
    }

}
