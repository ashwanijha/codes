/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.math3.distribution.TDistribution;
import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;

/**
 *
 * @author ajha
 * @date created 24-May-2017
 * 
 * javac -cp ".:guava-19.0.jar:commons-math3-3.6.jar" PCC.java
 * java -cp ".:guava-19.0.jar:commons-math3-3.6.jar:" PCC test_file_for_cor.txt outfile.txt
 *
 */
public class PCC {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        
        PearsonsCorrelation corel = new PearsonsCorrelation();
        PCC method = new PCC();
        ArrayList<String> name = new ArrayList<>();
        Multimap<String,String> genes = ArrayListMultimap.create();
        BufferedWriter bw = new BufferedWriter(new FileWriter(args[1]));
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        String str;
        while((str=br.readLine())!=null)
        {
            String[] a = str.split("\t");
            name.add(a[0]);
            for(int i=1;i<a.length;i++)
            {
                genes.put(a[0], a[i]);
            }
        }
        for(String key : genes.keySet())
        {
            double[] first = new double[genes.get(key).size()];
            int element1=0;
            for(String value : genes.get(key))
            {
                double d = Double.parseDouble(value);
                first[element1]=d;
                element1++;
            }
            for(String key1 : genes.keySet())
            {
                if(!key.equals(key1))
                {
                    double[] second = new double[genes.get(key1).size()];
                    int element2 =0;
                    for(String value : genes.get(key1))
                    {
                        double d = Double.parseDouble(value);
                        second[element2]=d;
                        element2++;
                        
                    }
                    double corrlation =corel.correlation(first, second);
                    if(corrlation > 0.5)
                    {
                        bw.write(key+"\t"+key1+"\t"+corrlation+"\t"+method.pvalue(corrlation, second.length)+"\n");
                    }
                }
            }
        }
        br.close();
        bw.close();
    }
    
    public double pvalue(double corel, double n)
    {
        double t = Math.abs(corel * Math.sqrt( (n-2.0) / (1.0 - (corel * corel)) ));
        TDistribution tdist = new TDistribution(n-2);
        double pvalue = 2* (1.0 - tdist.cumulativeProbability(t));
        return pvalue; 
    }

}
