import java.io.FileNotFoundException;

public class Controller {

    private ListeNombresComplexes fft;
    private Fenetre fen;

    public void setFft(ListeNombresComplexes fft) {
        this.fft = fft;
    }

    public Fenetre getFen() {
        return fen;
    }

    public void setFen(Fenetre fen) {
        this.fen = fen;
    }

    public Controller(ListeNombresComplexes model){
        this.fft=model;
    }

    public void notifyAction(String adresse,int choix)
    {
        try {
            float valf[];
            NombreComplexe valC[];
            switch (choix) {
                case 1:
                    CSVController fichierCSV = new CSVController();
                    fichierCSV.read(adresse);
                    valC = fichierCSV.getTab();
                    this.fft.setTaille(valC.length);
                    this.fft.setSignalEntree(valC);
                    this.fft.FFT();
                    break;
               /* case 2:
                    valC=CSVReader.parseComplexeCSV(nomFichier);
                    this.fft.setSize(valC.length);
                    this.fft.inverseFFT(valC);
                    break;
                case 3:
                    CSVWriter.writeCSV(fft.getValeurs(),nomFichier);
                    break;*/
                default:
                    break;
            }
        }catch (NullPointerException|IllegalArgumentException e) {
            System.out.println("erreur");
        }
    }




}