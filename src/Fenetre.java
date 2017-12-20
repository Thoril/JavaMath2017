import javax.swing.*;
import javax.swing.border.Border;
import java.awt.BorderLayout;

public class Fenetre extends JFrame{

    private JButton bouton1 = new JButton("Calculer");
    private JButton bouton2 = new JButton("Effacer");

    private JMenuBar menuBar = new JMenuBar();
    private JMenu test1 = new JMenu("Fichier");
    private JMenu test2 = new JMenu("Edition");

    private JMenuItem item1 = new JMenuItem("Ouvrir");



    public Fenetre(){
        this.setTitle("La Transformee de Fourier");
        this.setSize(700, 800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());



        JPanel sud = new JPanel();
        sud.add(bouton1);
        sud.add(bouton2);

        this.add(sud, BorderLayout.SOUTH);

        this.test1.add(item1);
        this.menuBar.add(test1);
        this.setJMenuBar(menuBar);

        this.setVisible(true);

    }

}
