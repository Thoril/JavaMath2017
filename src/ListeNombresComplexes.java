
public class ListeNombresComplexes {

    private int taille;
    private NombreComplexe[] liste;

    public ListeNombresComplexes(int taille, NombreComplexe[] liste) {
        this.taille = taille;
        this.liste = liste;
    }


    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public NombreComplexe getListe(int position) {
        return liste[position];
    }

    public NombreComplexe[] FFT(){
        NombreComplexe[] S = new NombreComplexe[this.taille];
        //si la liste est de taille 1
        if(this.taille==1){
            //On copie le signal dans S
            S[0] = this.liste[0];
        }else{ //sinon on redivise la liste
            NombreComplexe[] tabPaire = new NombreComplexe[this.taille/2];   //On declare la liste des éléments paires
            NombreComplexe[] tabImpaire = new NombreComplexe[this.taille/2];  //On declare la liste des éléments impaires
            //On crée les 2 listes a partir de la liste principale
            for(int i=0;i<this.taille/2;i++){
                tabPaire[i]=this.liste[2*i];
                tabImpaire[i]=this.liste[2*i+1];
            }
            //On initialise les deux objets qui continent les listes
            ListeNombresComplexes paire = new ListeNombresComplexes(this.taille/2, tabPaire);
            ListeNombresComplexes impaire = new ListeNombresComplexes(this.taille /2, tabImpaire);
            //On calcule la FFT des deux listes
            NombreComplexe[] Rpaire = paire.FFT();
            NombreComplexe[] Rimpaire =  impaire.FFT();
            //On initialise notre multiplicateur
            for(int i=0;i<this.taille/2;i++ ){
                //On incremente le multiplicateur
                double m = -2*Math.PI*i/this.taille;
                NombreComplexe multi =  new NombreComplexe(Math.cos(m),Math.sin(m));
                //Notre liste de retour prend la valeur de la liste paire pour la premiere moitié
                S[i] = Rpaire[i].plus(Rimpaire[i].fois(multi));
                //Et la valeur de la liste impaire pour la seconde moitié
                S[i+this.taille/2] = Rpaire[i].moins(Rimpaire[i].fois(multi));
            }
        }
        //On retourne notre liste S
        return S;
    }
}
