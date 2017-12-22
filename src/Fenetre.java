import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileFilter;
import java.util.Observable;
import java.util.Observer;

public class Fenetre extends JFrame implements ActionListener, Observer{


    private Controller controller;
    private String chemin;
    private JButton bouton1 = new JButton("Calculer");
    private JButton bouton2 = new JButton("Effacer");

    private JMenuBar menuBar = new JMenuBar();
    private JMenu fichier = new JMenu("Fichier");
    private JMenu test2 = new JMenu("Edition");

    private JMenuItem item1 = new JMenuItem("Ouvrir");

    private JFreeChart jc;
    private ChartPanel cp;
    private int choixActuel;



    public Fenetre(Controller controllerP){
        this.setTitle("La Transformee de Fourier");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.controller=controllerP;



        //Bouton en borderlayout sud
        JPanel sud = new JPanel();
        sud.add(bouton1);
        sud.add(bouton2);

        JPanel centre = new JPanel();
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Analyse Spectrale", "N", "Magnitude",
                null, PlotOrientation.VERTICAL, true, true,false);
        cp= new ChartPanel(chart) {

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(650, 500);
            }
        };
        pack();

        centre.add(cp);

        this.add(centre,BorderLayout.CENTER);

        this.add(sud, BorderLayout.SOUTH);

        item1.addActionListener(this);
        bouton1.addActionListener(this);

        //Menu
        this.fichier.add(item1);
        this.menuBar.add(fichier);
        this.setJMenuBar(menuBar);

        this.setSize(700, 800);
        this.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == item1){
            this.choixActuel = 1;
            System.out.println("test");
            JFileChooser choix = new JFileChooser();
            FileNameExtensionFilter MonFiltre = new FileNameExtensionFilter("Fichier en .csv", "csv");
            choix.addChoosableFileFilter(MonFiltre);
            choix.setAcceptAllFileFilterUsed(false);
            int retour= choix.showOpenDialog(this);
            if(retour==JFileChooser.APPROVE_OPTION){
                this.chemin =choix.getSelectedFile().getAbsolutePath();
                System.out.print("Chemin: ");

                System.out.println(this.chemin);
            }
        }
        if(e.getSource() == bouton1){
            this.controller.notifyAction(this.chemin,this.choixActuel);
        }
    }


    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof ListeNombresComplexes) {
            ListeNombresComplexes fft=(ListeNombresComplexes) o;
            XYSeries Goals = new XYSeries("Transformée de Fourier");
            for (int i = 0; i<fft.getSortieFourier().length;i++)
            {
                Goals.add(i,fft.getSortieFourier(i).module());
            }
            XYDataset xyDataset = new XYSeriesCollection(Goals);
            JFreeChart chart = ChartFactory.createXYLineChart(
                    "Goals Scored Over Time", "N", "Magnitude",
                    xyDataset, PlotOrientation.VERTICAL, true, false, false);
            this.cp.setChart(chart);
        }
    }
}
