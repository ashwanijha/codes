/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Date Jul 19, 2012
 * @author ashwani
 */
public class extract_top_score throws IOException {
    static ArrayList<String> list = new ArrayList<String>();
    static ArrayList<String> list2 = new ArrayList<String>();

  public static void main(String[] args) throws IOException
    {
        BufferedWriter bw = new BufferedWriter(new FileWriter(args[1]));

        extract_top_scoringTF o = new extract_top_scoringTF();
        
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        String str;
        Pattern p = Pattern.compile(">");
        int i=0;
        while((str = br.readLine())!=null)
        {
            Matcher m = p.matcher(str);
            if(m.find())
            {
               o.max();
                 for(String key : list2)
                    {
                       bw.write(key+"\n");
                       bw.flush();
                    }
                
               bw.write("\n"+str +"\n");
             
               list2.clear();
                continue;
            }
            
            list.add(str);
            
        }
       o.max();
        for(String key : list2)
                    {
                       bw.write(key+"\n");
                       bw.flush();
                    }

         bw.close();       
       
    }

    
    
    public void max() throws IOException
    {
 
        ArrayList<String> l1 = new ArrayList<String>();
          for(String key : list)
        {
            String[] a= key.split("\t");
            l1.add(a[0]);
        }
 
        Set <String> unique = new LinkedHashSet<String>(l1);
        String [] tfs = list.toArray(new String[list.size()]);
     
        
        
          for(String key : unique)
        {
            ArrayList<Double> score1 = new ArrayList<Double>();
             ArrayList<String> list1 = new ArrayList<String>();
            
          for(int i=0;i< tfs.length;i++)
        {
            String g = tfs[i].toString();
            String[] a = g.split("\t");

            if(key.equals(a[0]))
            {
              double d = Double.valueOf(a[4].trim()).doubleValue(); // top score of 4th column please change accordingly
              score1.add(d);
              list1.add(g);
  
            }
        }
            double max = Collections.max(score1);
          
          int fet = score1.indexOf(max);
   
          list2.add(list1.get(fet));
          

          list1.clear();
          score1.clear();
        }
      l1.clear();

      list.clear();
    }
    
}
