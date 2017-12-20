import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileFilter;

public class Fenetre extends JFrame implements ActionListener{

    private JButton bouton1 = new JButton("Calculer");
    private JButton bouton2 = new JButton("Effacer");

    private JMenuBar menuBar = new JMenuBar();
    private JMenu fichier = new JMenu("Fichier");
    private JMenu test2 = new JMenu("Edition");

    private JMenuItem item1 = new JMenuItem("Ouvrir");



    public Fenetre(){
        this.setTitle("La Transformee de Fourier");
        this.setSize(700, 800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());


        //Bouton en borderlayout sud
        JPanel sud = new JPanel();
        sud.add(bouton1);
        sud.add(bouton2);

        this.add(sud, BorderLayout.SOUTH);

        item1.addActionListener(this);

        //Menu
        this.fichier.add(item1);
        this.menuBar.add(fichier);
        this.setJMenuBar(menuBar);


        this.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == item1){
            System.out.println("test");
            JFileChooser choix = new JFileChooser();
            FileNameExtensionFilter MonFiltre = new FileNameExtensionFilter("Tableau", "csv");
            choix.addChoosableFileFilter(MonFiltre);
            choix.setAcceptAllFileFilterUsed(false);
            int retour= choix.showOpenDialog(this);
            if(retour==JFileChooser.APPROVE_OPTION){
                String chemin =choix.getSelectedFile().getAbsolutePath();
                System.out.print("Chemin: ");
                System.out.println(chemin);
            }
        }
    }
}
