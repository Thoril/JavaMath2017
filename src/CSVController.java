import java.io.*;

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

    public void read(String adresse) {

        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(adresse))) {
            int indice = 0;
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String retour[] = line.split(cvsSplitBy);
                tab[indice] = new NombreComplexe( Double.parseDouble(retour[0]),Double.parseDouble(retour[1]));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void write(String nom) {
        try{
            File ff=new File(nom+".txt"); // définir l'arborescence
            ff.createNewFile();
            FileWriter fw=new FileWriter(ff);
            for(NombreComplexe nb: tab){
                fw.write(String.valueOf(nb.getReel()));
                fw.write(",");
                fw.write(String.valueOf(nb.getImaginaire()));
                fw.write("\n");
            }
            fw.close();
        } catch (Exception e) {}


    }



}
