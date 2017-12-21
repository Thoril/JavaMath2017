import java.io.*;

/**
 * Classe CSV Controller
 * Permet de lire et d'ecrire des fichiers csv a l'aide d'un tableau de complex
 */
public class CSVController {
    private NombreComplexe tab[];

    public NombreComplexe[] getTab() {
        return tab;
    }

    public void setTab(NombreComplexe[] tab) {
        this.tab = tab;
    }

    public CSVController(NombreComplexe[] tab) {
        this.tab = tab;
    }

    public CSVController() {
    }

    /**
     * Lis un fichier csv et ecris les données dans un tableau de complexe
     * @param adresse adresse du fichier a lire
     */
    public void read(String adresse) {
        String line = "";
        int indice = 0;
        //Dans un premier temps on compte le nombre de ligne
        try (BufferedReader br = new BufferedReader(new FileReader(adresse))) {
            while ((line = br.readLine()) != null) {
                indice++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        //Ensuite on creer un tableau de complexe pour accueillir les valeurs
        String cvsSplitBy = ";";
        tab= new NombreComplexe[indice];
        //Chaque ligne correspond a un nouveau nombre complexe avec la partie réelle et la partie imaginaire
        try (BufferedReader br = new BufferedReader(new FileReader(adresse))) {
            indice = 0;
            while ((line = br.readLine()) != null) {
                String retour[] = line.split(cvsSplitBy);
                double reel = Double.valueOf(retour[0]);
                double imag = Double.valueOf(retour[1]);
                tab[indice] = new NombreComplexe(reel,imag);
                indice++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Ecris le tableau de complexe de l'objet dans un fichier dont l'adresse est passé en parametre
     * @param nom adresse et nom du fichier ou l'on sauvegarde le tableau
     */
    public void write(String nom) {
        try{
            File ff=new File(nom+".csv"); // définir l'arborescence
            ff.createNewFile();
            FileWriter fw=new FileWriter(ff);
            for(NombreComplexe nb: tab){
                fw.write(String.valueOf(nb.getReel()));
                fw.write(";");
                fw.write(String.valueOf(nb.getImaginaire()));
                fw.write("\n");
            }
            fw.close();
        } catch (Exception e) {}


    }



}
