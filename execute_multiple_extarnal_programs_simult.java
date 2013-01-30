/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//package execute_multiple_extarnal_programs_simult;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author ashwani
 */
public class execute_multiple_extarnal_programs_simult {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader br = new BufferedReader(new FileReader("list")); // file to iterate the code 

        int processor = Integer.parseInt(args[0]); // number of threads

        String str;
        while((str = br.readLine())!=null)
        {
             WorkerThreads[] workers = new WorkerThreads[processor];
        ExecutorService taref = Executors.newFixedThreadPool(processor);
         String[] p = new String[processor];
                p[0] = str;
            workers[0] = new WorkerThreads(p[0],0);

            taref.execute(workers[0]);
            for(int k = 1;k < processor;k++)
            {

                p[k] = br.readLine();
                workers[k] = new WorkerThreads(p[k],k);
                 taref.execute(workers[k]);

            }
                taref.shutdown();
           try {

         taref.awaitTermination(processor, TimeUnit.DAYS);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }

        }

     }

}




class WorkerThreads implements Runnable
{


 public String str;
 public int k;


    WorkerThreads(String string,int i) {
 
            str = string;
            k = i;
          
            }
    @Override
    public void run() throws UnsupportedOperationException {
        try {
 //System.out.println(k+"\t"+str);
   Process pros = Runtime.getRuntime().exec("java find_expression id_nems "+str+" expression/expression-"+k); // insert the program name here
     BufferedReader br = new BufferedReader(new InputStreamReader(pros.getInputStream()));

      String g = null;
     while((g=br.readLine())!=null)
     {

     }
     br.close();

}catch(Exception e)
{
}

}
}
