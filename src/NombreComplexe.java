import org.apache.log4j.Logger;
import java.text.DecimalFormat;

public class NombreComplexe {
    private double reel;
    private double imaginaire;
    private static final Logger log = Logger.getLogger(NombreComplexe.class);

    public NombreComplexe(double reel, double imaginaire) {
        //log.info("Creation d'un Nombre Complexe");
        this.reel = reel;
        this.imaginaire = imaginaire;
    }

    public double getReel() {
        return reel;
    }

    public void setReel(double reel) {
        this.reel = reel;
    }

    public double getImaginaire() {
        return imaginaire;
    }

    public void setImaginaire(double imaginaire) {
        this.imaginaire = imaginaire;
    }

    public NombreComplexe plus(NombreComplexe terme) {
        double reel = this.reel + terme.getReel();
        double imaginaire = this.imaginaire + terme.getImaginaire();
        return new NombreComplexe(reel, imaginaire);
    }

    public NombreComplexe moins(NombreComplexe diminuteur) {
        double reel = this.reel - diminuteur.getReel();
        double imaginaire = this.imaginaire - diminuteur.getImaginaire();
        return new NombreComplexe(reel, imaginaire);

    }

    public NombreComplexe fois(NombreComplexe facteur) {
        double reel = this.reel * facteur.getReel() - this.imaginaire * facteur.getImaginaire();
        double imaginaire = this.reel * facteur.getImaginaire() + this.imaginaire * facteur.getReel();
        return new NombreComplexe(reel, imaginaire);
    }

    public void affiche() {
        if (this.imaginaire == 0) {
            System.out.printf("%.3f\n", this.reel);
        } else {
            System.out.printf("%.3f+i*%.3f\n", this.reel, this.imaginaire);
        }
    }

    @Override
    public String toString() {
        //On limite le nombre de chiffre significatif apres la virgule a 3
        DecimalFormat df=new DecimalFormat();
        df.setMaximumFractionDigits(3);
        return df.format(this.reel)+" + "+df.format(this.imaginaire)+" i";
    }

    public NombreComplexe conjugue(){
        double reel = this.reel;
        double imaginaire  = -1* this.imaginaire;
        return new NombreComplexe(reel, imaginaire);
    }
}