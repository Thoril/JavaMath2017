import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CSVControllerTest {
    @Test
    void read() {
        CSVController test = new CSVController();
        test.read("src/retour.csv");
        NombreComplexe[] tab = test.getTab();
        for(NombreComplexe nb : tab){
            nb.affiche();
        }



    }

    @Test
    void write() {
        NombreComplexe[] tab = new NombreComplexe[10];
        for(int i =0;i<10;i++){
            tab[i] = new NombreComplexe(i+2,i+1);
        }
        CSVController test = new CSVController(tab);
        test.write("retour");
    }


}