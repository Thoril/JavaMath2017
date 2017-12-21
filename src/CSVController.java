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

    public CSVController() {
    }

    public void read(String adresse) {
        String line = "";
        int indice = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(adresse))) {
            while ((line = br.readLine()) != null) {
                indice++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        String cvsSplitBy = ";";
        tab= new NombreComplexe[indice];
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
