/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package grafoss;

import edu.uci.ics.jung.algorithms.layout.*;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.Renderer;
import edu.uci.ics.jung.algorithms.shortestpath.DijkstraShortestPath;
import edu.uci.ics.jung.graph.*;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author Diego
 */
public class Grafoss {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Graph<String,String> grafo = new UndirectedSparseGraph<String,String>();

        grafo.addVertex("Sogamoso");
        grafo.addVertex("Aquitania");
        grafo.addVertex("Firavitoba");
        grafo.addVertex("Gameza");
        grafo.addVertex("Iza");
        grafo.addVertex("Mongua");
        grafo.addVertex("Mongui");
        grafo.addVertex("Nobsa");
        grafo.addVertex("Pesca");
        grafo.addVertex("Tibasosa");
        grafo.addVertex("Topaga");
        grafo.addVertex("Tota");
        grafo.addVertex("Cuitiva");

        grafo.addEdge("13.4","Sogamoso","Mongui");
        grafo.addEdge("4.7","Sogamoso","Nobsa");
        grafo.addEdge("7.6","Sogamoso","Tibasosa");
        grafo.addEdge("11.6","Firavitoba","Sogamoso");
        grafo.addEdge("12.9","Sogamoso","Iza");
        grafo.addEdge("20","Sogamoso","Cuitiva");
        grafo.addEdge("7","Mongui","Topaga");
        grafo.addEdge("13.5","Mongui","Mongua");
        grafo.addEdge("18.6","Mongui","Nobsa");
        grafo.addEdge("16.5","Topaga","Gameza");
        grafo.addEdge("9.4","Gameza","Mongua");
        grafo.addEdge("11","Nobsa","Tibasosa");
        grafo.addEdge("19","Tibasosa","Firavitoba");
        grafo.addEdge("6.8","Firavitoba","Iza");
        grafo.addEdge("5.2","Iza","Cuitiva");
        grafo.addEdge("11.1","Iza","Tota");
        grafo.addEdge("5.8","Cuitiva","Tota");
        grafo.addEdge("22.8","Cuitiva","Aquitania");
        grafo.addEdge("13.1","Aquitania","Tota");
        grafo.addEdge("7.4","Tota","Pesca");

        VisualizationViewer<String,String> visual = new VisualizationViewer<String, String>(
                new KKLayout<>(grafo), new Dimension(400,400)
        );

        visual.getRenderContext().setVertexLabelTransformer(new ToStringLabeller<String>());
        visual.getRenderer().getVertexLabelRenderer().setPosition(Renderer.VertexLabel.Position.CNTR);

        JPanel panel = new JPanel();
        panel.add(visual);

        JLabel labelOne = new JLabel("Destino");
        JLabel labelTwo = new JLabel("Distancia");
        JLabel lableThree = new JLabel("Tiempo");
        JComboBox comboBox = new JComboBox();
        JTextField fieldOne = new JTextField();
        fieldOne.setEditable(false);
        JTextField fieldTwo = new JTextField();
        fieldTwo.setEditable(false);
        JButton btn = new JButton("Calcular");

        String[] options = {"Aquitania","Firavitoba","Gameza","Iza","Mongua","Mongui","Nobsa","Pesca","Tibasosa","Topaga","Tota","Cuitiva"};

        for (String option : options){
            comboBox.addItem(option);
        }

        JPanel panelDos = new JPanel();
        panelDos.setLayout(new GridLayout(9,2));
        panelDos.add(new JLabel());
        panelDos.add(new JLabel());
        panelDos.add(new JLabel());
        panelDos.add(new JLabel());
        panelDos.add(labelOne);
        panelDos.add(comboBox);
        panelDos.add(new JLabel());
        panelDos.add(new JLabel());
        panelDos.add(labelTwo);
        panelDos.add(fieldOne);
        panelDos.add(new JLabel());
        panelDos.add(new JLabel());
        panelDos.add(lableThree);
        panelDos.add(fieldTwo);
        panelDos.add(new JLabel());
        panelDos.add(new JLabel());
        panelDos.add(new JLabel());
        panelDos.add(btn);

        JFrame frame = new JFrame("Distancia y tiempo de llegada");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setLayout(new GridLayout(1,2));
        frame.add(panel);
        frame.add(panelDos);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        btn.addActionListener((ActionEvent)->{
            double distanciaRecorrida=0.0;
            double tiempo = 0;

            DijkstraShortestPath<String, String> dijkstra = new DijkstraShortestPath<String, String>(grafo);
            String ciudadFinal = (String) comboBox.getSelectedItem();
            try {

                for (String v : dijkstra.getPath("Sogamoso", ciudadFinal)) {
                        distanciaRecorrida+=Double.valueOf(v);

                }
                fieldOne.setText(distanciaRecorrida + " Km");
                tiempo = distanciaRecorrida*1.3;
                fieldTwo.setText(tiempo + " minutos");
            } catch (Exception e) {
                
            }
        });
    }
    
}
