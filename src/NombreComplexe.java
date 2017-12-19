public class NombreComplexe {
    private double reel;
    private double imaginaire;

    public NombreComplexe(double reel, double imaginaire) {
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

    public NombreComplexe plus(NombreComplexe terme ){
        double reel = this.reel + terme.getReel();
        double imaginaire = this.imaginaire + terme.getImaginaire();
        return new NombreComplexe(reel, imaginaire);
    }

    public NombreComplexe moins(NombreComplexe diminuteur ){
        double reel = this.reel - diminuteur.getReel();
        double imaginaire = this.imaginaire - diminuteur.getImaginaire();
        return new NombreComplexe(reel, imaginaire);
    }

    public NombreComplexe fois(NombreComplexe facteur){
        double reel = this.reel * facteur.getReel() - this.imaginaire * facteur.getImaginaire();
        double imaginaire = this.reel * facteur.getImaginaire() + this.imaginaire * facteur.getReel();
        return new NombreComplexe(reel, imaginaire);
    }
    public void affiche(){
        System.out.printf("%f+i*%f\n",this.reel,this.imaginaire);
    }
}
