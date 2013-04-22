/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reg_network;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jgraph.JGraph;
import org.jgraph.graph.DefaultGraphCell;
import org.jgraph.graph.GraphConstants;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.jgraph.graph.AttributeMap;
import org.jgrapht.DirectedGraph;
import org.jgrapht.ListenableGraph;
import org.jgrapht.ext.JGraphModelAdapter;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultListenableGraph;
import org.jgrapht.graph.DirectedMultigraph;


/**
 *
 * @author ashwani
 */
public class Reg_network extends JApplet {

    /**
     * @param args the command line arguments
     */
   static int size = 0;
    
        private static final long serialVersionUID = 3256444702936019250L;
   // private static final Color DEFAULT_BG_COLOR = Color.decode("#FAFBFF");
    private static final Dimension DEFAULT_SIZE = new Dimension(1100, 900);
    private static final String friend = "friend";

    //~ Instance fields --------------------------------------------------------

    //
    private JGraphModelAdapter<String,DefaultEdge> jgAdapter;
    
 // public void paint (Graphics g)
{
///g.drawString ("The graphics are quite simple", 40, 75);
}

    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
                    
                         Reg_network applet = new Reg_network();
        applet.init("/data_bkup/RdDM_analysis/ath_investigative_study_ms/Network_analysis/result","AT1G01280");
         
         JLabel c = new JLabel("dfdf");
        c.setText("");

        JFrame frame = new JFrame();
        frame.getContentPane().add(applet);
       
        frame.setTitle("Network");
        
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
           frame.pack();
   
        frame.setVisible(true);
     }
   
    public void Rn(){
                
            JOptionPane.showMessageDialog(null,"Missing values : No complete network can be drawn", "Error",JOptionPane.ERROR_MESSAGE);
            
	}
    
    
     public void init(String filename,String center)
    {
        // create a JGraphT graph
      //  ListenableGraph<String, DefaultEdge> g =  new ListenableDirectedMultigraph<String, DefaultEdge>(DefaultEdge.class);

         
        ListenableGraph<String, DefaultEdge> g =
            new ListenableDirectedMultigraph<String, DefaultEdge>(
                DefaultEdge.class);
        
        
     try{
       
        
        // create a visualization using JGraph, via an adapter
           
        jgAdapter = new JGraphModelAdapter<String, DefaultEdge>(g);

        JGraph jgraph = new JGraph(jgAdapter);

      //  String style = "fillColor=#FFFFFF;strokecolor=#FFFFFF;perimeter=rectanglePerimeter;imageWidth=80;imageHeight=80;image=img.png";
      //  ********** to add image uncomment the 2 lines below
        
        // private ImageIcon backgroundImgIcon = new ImageIcon("/data_bkup/RdDM_analysis/ath_investigative_study_ms/Network_analysis/d1_wm.png") ;
        
        //        jgraph.setBackgroundImage(backgroundImgIcon);
        
        
        // \ncell = graph.insertVertex(graphParentCell, null, node, 0, 0, 80, 80, style);\n
        
        
        getContentPane().add(jgraph);
        
        resize(DEFAULT_SIZE);
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String str;
      
         String v1 = center;
          g.addVertex(v1);
          positionVertexAt(v1, 850, 250);
          

         Color c = Color.decode("#FAFBFF");
         String xx = null;
        while((str=br.readLine())!=null)
        {
            adjustDisplaySettings(jgraph,c);
          
           // System.out.println("abcd");
                   if(str.contains("network"))
            {
              
                String cc = br.readLine();
                if(cc.contains("gene_tf"))
                {
                    Rn();
                  // jgraph.cancelEditing();
                    break;
                }
                    String [] s1 = cc.split("\t");
                      xx = s1[0];
            
              String v2 = s1[2];
              g.addVertex(v2);
            //  String v3 = s1[0];
            //  g.addVertex(v3);
              
             boolean e1 = g.addEdge(v1, v2 , new RelationshipEdge<String>("sa", "s1", s1[1],"#9966FF"  ));
             // boolean e2 = g.addEdge(v3, v2 , new RelationshipEdge<String>("sa", "s1", s1[1] ));
             positionVertexAt(v2, 100 , 750);
            //  positionAT(v3, 200 , 300);
            
            }
             
          else if(str.contains("gene_tf"))
             {
                 String a;
                 while((a=br.readLine())!=null)
                 {
                     if(a.isEmpty())
                     {
                         break;
                     }
                     else
                     {
                        String [] s = a.split("\t"); 
                         
                         String v2 = s[0];
                          g.addVertex(v2);
                         // System.out.println(s[0]);
                          boolean e1 = g.addEdge(v1, v2 , new RelationshipEdge<String>("sa", "s1", s[1],"#9966FF"  ));
                        //  positionAT(v2, 100+i , 100+j);
                     }
                 }
             }
           else if(str.contains("mir_data"))
             {
                  int i =0;
                 int j =0;
                  String a;
                 while((a=br.readLine())!=null)
                 {
                     
                     if(a.isEmpty())
                     {
                         break;
                     }
                     else
                     {
                         i+=80;
                         j+=75;
                         String [] s = a.split("\t"); 
                         String v2 = s[0];
                          g.addVertex(v2);
                          String v3 = s[2];
                          g.addVertex(v3);
                                boolean e1 = g.addEdge(v3, v2 , new RelationshipEdge<String>("sa", "s1", s[1],"#4CC417" ));
                           
                     }
                 }
             }
            
             else if(str.contains("protein"))
             {
                  String a=br.readLine();
                 String [] s = a.split("\t"); 
                 String v3 = s[2];
                 g.addVertex(v3);
                 String v2 = s[0];
                 g.addVertex(v2);
                 boolean e1 = g.addEdge(v3, v2 , new RelationshipEdge<String>("sa", "s1", s[1] ,"#9966FF"));
                 
             }
                            
        }
        br.close();
        


    }
      catch (Exception ex) {
            Logger.getLogger(Reg_network.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    private void adjustDisplaySettings(JGraph jg, Color colour)
    {
        jg.setPreferredSize(DEFAULT_SIZE);
 //colour = DEFAULT_BG_COLOR;
        Color c = colour;
        String colorStr = null;

        try {
            colorStr = getParameter("bgcolor");
        } catch (Exception e) {
        }

        if (colorStr != null) {
            c = Color.decode(colorStr);
        }

        jg.setBackground(c);
    }

    
  

    private void  positionAT(Object vertex,int x,int y){
        
          DefaultGraphCell cell = jgAdapter.getVertexCell(vertex);
        AttributeMap attr = cell.getAttributes();
       
           Rectangle2D bounds = GraphConstants.getBounds(attr);
        //System.out.println(attr);
         Ellipse2D.Double nb  = new Ellipse2D.Double(x,y,300,300);
           
           // Ellipse2D b = GraphConstants.getBounds(attr);
           
      //  Ellipse2D bounds = GraphConstants.getBounds(attr);

        Rectangle2D newBounds =
            new Rectangle2D.Double(
                x,
                y,
               140,
                23);
         //  System.out.println(bounds.getHeight());
            
        
        
      //  Ellipse2D newBounds = 

           
           
        GraphConstants.setBounds(attr, newBounds);
          
        GraphConstants.setBackground(attr, Color.decode("#4CC417"));
        // TODO: Clean up generics once JGraph goes generic
        AttributeMap cellAttr = new AttributeMap();
        cellAttr.put(cell, attr);
       //  System.out.println(attr);
        jgAdapter.edit(cellAttr, null, null, null);
        
        
        
}
    
    
    private void  positionAT1(Object vertex,int x,int y){
        
          DefaultGraphCell cell = jgAdapter.getVertexCell(vertex);
        AttributeMap attr = cell.getAttributes();
       
           Rectangle2D bounds = GraphConstants.getBounds(attr);
        //System.out.println(attr);
         Ellipse2D.Double nb  = new Ellipse2D.Double(x,y,300,300);
           
           // Ellipse2D b = GraphConstants.getBounds(attr);
           
      //  Ellipse2D bounds = GraphConstants.getBounds(attr);

        Rectangle2D newBounds =
            new Rectangle2D.Double(
                x,
                y,
               140,
                23);
         //  System.out.println(bounds.getHeight());
            
        
        
      //  Ellipse2D newBounds = 

           
           
        GraphConstants.setBounds(attr, newBounds);
          
        GraphConstants.setBackground(attr, Color.decode("#C9BE62"));
        // TODO: Clean up generics once JGraph goes generic
        AttributeMap cellAttr = new AttributeMap();
        cellAttr.put(cell, attr);
       //  System.out.println(attr);
        jgAdapter.edit(cellAttr, null, null, null);
        
        
        
}
    private void  positionAT2(Object vertex,int x,int y){
        
          DefaultGraphCell cell = jgAdapter.getVertexCell(vertex);
        AttributeMap attr = cell.getAttributes();
       
           Rectangle2D bounds = GraphConstants.getBounds(attr);
        //System.out.println(attr);
         Ellipse2D.Double nb  = new Ellipse2D.Double(x,y,300,300);
           
           // Ellipse2D b = GraphConstants.getBounds(attr);
           
      //  Ellipse2D bounds = GraphConstants.getBounds(attr);

        Rectangle2D newBounds =
            new Rectangle2D.Double(
                x,
                y,
               140,
                23);
         //  System.out.println(bounds.getHeight());
            
        
        
      //  Ellipse2D newBounds = 

           
           
        GraphConstants.setBounds(attr, newBounds);
          
        GraphConstants.setBackground(attr, Color.decode("#9966FF")); // E6A9EC
        // TODO: Clean up generics once JGraph goes generic
        AttributeMap cellAttr = new AttributeMap();
        cellAttr.put(cell, attr);
       //  System.out.println(attr);
        jgAdapter.edit(cellAttr, null, null, null);
        
        
        
}
    
    
    
    @SuppressWarnings("unchecked") 
    private void positionVertexAt(Object vertex, int x, int y)
    {
        DefaultGraphCell cell = jgAdapter.getVertexCell(vertex);
        AttributeMap attr = cell.getAttributes();
       
           Rectangle2D bounds = GraphConstants.getBounds(attr);
        //System.out.println(attr);
         Ellipse2D.Double nb  = new Ellipse2D.Double(x,y,300,300);
           
           // Ellipse2D b = GraphConstants.getBounds(attr);
           
      //  Ellipse2D bounds = GraphConstants.getBounds(attr);

        Rectangle2D newBounds =
            new Rectangle2D.Double(
                x,
                y,
               140,
                23);
         //  System.out.println(bounds.getHeight());
            
        
        
      //  Ellipse2D newBounds = 

           
           
        GraphConstants.setBounds(attr, newBounds);
          
        GraphConstants.setBackground(attr, Color.decode("#1569C7")); // #C9BE62 #A74AC7
        // TODO: Clean up generics once JGraph goes generic
        AttributeMap cellAttr = new AttributeMap();
        cellAttr.put(cell, attr);
       //  System.out.println(attr);
        jgAdapter.edit(cellAttr, null, null, null);
    }

    
    
    
    
    
   
    //~ Inner Classes ----------------------------------------------------------

    /**
     * a listenable directed multi graph that allows loops and parallel edges.
     */
    private static class ListenableDirectedMultigraph<V, E>
        extends DefaultListenableGraph<V, E>
        implements DirectedGraph<V, E>
    {
        private static final long serialVersionUID = 1L;

        ListenableDirectedMultigraph(Class<E> edgeClass)
        {
            super(new DirectedMultigraph<V, E>(edgeClass));
                      
            
        }
    }
    
    
    
    public static class RelationshipEdge<V> extends DefaultEdge {
        private V v1;
        private V v2;
        private String label;
        private Color cl;

        public RelationshipEdge(V v1, V v2, String label,String col) {
            this.v1 = v1;
            this.v2 = v2;
            this.label = label; 
            this.cl = Color.decode(col) ;
            }

        public V getV1() {
            return v1;
        }

        public V getV2() {
            return v2;
        }

        @Override
        public String toString() {
            return label;
        }
        
      public Color colour() {
            return cl;
        }
        
    
}
}
