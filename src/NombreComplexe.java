import org.apache.log4j.Logger;
import java.text.DecimalFormat;

public class NombreComplexe {
    private double reel;
    private double imaginaire;
    private static final Logger log = Logger.getLogger(NombreComplexe.class);

    /**
     * Controleur de notre classe
     * @param reel
     * @param imaginaire
     */
    public NombreComplexe(double reel, double imaginaire) {
        //log.info("Creation d'un Nombre Complexe");
        this.reel = reel;
        this.imaginaire = imaginaire;
    }

    /**
     * Récupère la partie réelle d'un nombre complexe
     * @return
     */
    public double getReel() {
        return reel;
    }

    /**
     * Initiliase la partie réelle d'un nombre complexe
     * @param reel
     */
    public void setReel(double reel) {
        this.reel = reel;
    }

    /**
     * Récupère la partie imaginaire d'un nombre complexe
     * @return
     */
    public double getImaginaire() {
        return imaginaire;
    }

    /**
     * Initialise la partie imaginaire d'un nombre complexe
     * @param imaginaire
     */
    public void setImaginaire(double imaginaire) {
        this.imaginaire = imaginaire;
    }

    /**
     * Fonction qui calcule l'addition de deux nombre complexes
     * @param terme
     * @return un nombre complexe
     */
    public NombreComplexe plus(NombreComplexe terme) {
        double reel = this.reel + terme.getReel();
        double imaginaire = this.imaginaire + terme.getImaginaire();
        return new NombreComplexe(reel, imaginaire);
    }

    /**
     * Fonction qui calcule la soustraction de deux nombres complexes
     * @param diminuteur
     * @return un nombre complexe
     */
    public NombreComplexe moins(NombreComplexe diminuteur) {
        double reel = this.reel - diminuteur.getReel();
        double imaginaire = this.imaginaire - diminuteur.getImaginaire();
        return new NombreComplexe(reel, imaginaire);

    }

    /**
     * Fonction qui calcule la multiplication de deux nombres complexes
     * @param facteur
     * @return un nombre complexe
     */
    public NombreComplexe fois(NombreComplexe facteur) {
        double reel = this.reel * facteur.getReel() - this.imaginaire * facteur.getImaginaire();
        double imaginaire = this.reel * facteur.getImaginaire() + this.imaginaire * facteur.getReel();
        return new NombreComplexe(reel, imaginaire);
    }

    /**
     * Fonction qui affiche la partie réelle et la partie imaginaire d'un nombre complexe
     */
    public void affiche() {
        if (this.imaginaire == 0) {
            System.out.printf("%.3f\n", this.reel);
        } else {
            System.out.printf("%.3f+i*%.3f\n", this.reel, this.imaginaire);
        }
    }

    /**
     * Limite le nombre de chiffre significatif à 3 chiffres après la virgule
     * @return Le nouveau format d'un nombre complexe
     */
    @Override
    public String toString() {
        //On limite le nombre de chiffre significatif apres la virgule a 3
        DecimalFormat df=new DecimalFormat();
        df.setMaximumFractionDigits(3);
        return df.format(this.reel)+" + "+df.format(this.imaginaire)+" i";
    }

    /**
     * Fonction qui calcule le conjugue d'un nombre complexe
     * @return conjugue d'un nombre complexe
     */
    public NombreComplexe conjugue(){
        double reel = this.reel;
        double imaginaire  = -1* this.imaginaire;
        return new NombreComplexe(reel, imaginaire);
    }

    /**
     * Fonction qui calcule le module d'un nombre complexe
     * @return le module
     */
    public double module(){
        return Math.sqrt(Math.pow(this.reel,2)+ Math.pow(this.imaginaire,2));
    }
}