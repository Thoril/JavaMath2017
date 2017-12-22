public class FenetreTest {

    public static void main(String[] args) {
       // Fenetre win = new Fenetre();

        NombreComplexe[] liste = new NombreComplexe[8];
        for(int i= 0; i<liste.length; i++){
            //Initialisation du tableau avec les nombres complexes, partie réelle = 1, partie imaginaire = 0
            liste[i] = new NombreComplexe(1, 0);
        }

        ListeNombresComplexes ff=new ListeNombresComplexes(liste.length,liste);
        Controller controller=new Controller(ff);
        Fenetre fen = new Fenetre(controller);
        ff.addObserver(fen);
        controller.setFft(ff);
        controller.setFen(fen);

    }
}
