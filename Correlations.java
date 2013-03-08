/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
/**
 *
 * @author ashwani
 */
public class Correlations {

 public static double  corR =-1;

public static  String ss = null;

<<<<<<< HEAD
      public static double corcoeff(String str,String argument, String mirna, String target, String fname) throws IOException
=======
      public static double corcoeff(String str,String argument, String mirna, String target, String fname, double user_r) throws IOException
>>>>>>> eef31af9f9e802e6552a63d7f2d7be03c5bdd5b5
            {
                {
                double cor_sub = 0;
                double SD =0 ;
            float x = 0;
            float y =0;
              double t1 =0;

                  double sd =0;
            float x1 = 0;
            float y1 = 0;
            double tot_1 = 0;
            double sttot_2 = 0;
            double tot_2 = 0;
  
 String str_1 = argument;
            {

                String[] a1 = str_1.split("\t");
                 for(int i = 0 ; i< a1.length; i ++)
                {
         

                    float j = Float.parseFloat(a1[i]);
                    x1 = x1 + j;
                }
                 y1 = x1/(a1.length);

                  for(int i = 0 ; i< a1.length; i ++)
                {
                    tot_1 = Float.parseFloat(a1[i]) - y1;

                    sttot_2 = Math.pow(tot_1,2);

                    tot_2 = tot_2 + sttot_2;

                }

                    double sd_2 = tot_2/(a1.length-1);
                double SD1 = Math.sqrt(sd_2);

                  double submission1 = 0;
      
                     float tot = 0;
                double tot1 = 0;
                double sttot1 = 0;
                double add =0;
        
                String[] a = str.split("\t");
                for(int k = 0 ; k< a.length; k ++)
                {


                    float j = Float.parseFloat(a[k]);
                    x = x + j;
                }


                y = x/(a.length);
           
                  for(int j = 0 ; j< a.length; j ++)
                {
                    tot = Float.parseFloat(a[j]) - y;

                    sttot1 = Math.pow(tot,2);
        
                    tot1 = tot1 + sttot1;
                                  }
   double sd_1 = tot1/(a.length-1);
                SD = Math.sqrt(sd_1);
                double submission = 0;
                double cor;
                  for(int i = 0 ; i< a1.length; i ++)
                {
                    submission1 = Float.parseFloat(a1[i]) - y1;

                     submission = Float.parseFloat(a[i]) - y;
                    cor = submission1*submission;
                          cor_sub = cor_sub + cor;

                 
                }
                
                 t1 = submission1;
                 sd = SD1;


            }
     

                  String[] s = str.split("\t");
                  double cor_y = cor_sub/(SD*sd);
                  double r = (cor_y)/(s.length-1);



                   // if(user_r)
                  // user_r

<<<<<<< HEAD
      if(r< 0)
=======
      if(r >= user_r)
>>>>>>> eef31af9f9e802e6552a63d7f2d7be03c5bdd5b5
                  {
      FileWriter f  = new FileWriter(fname,true);
                     BufferedWriter brw = new BufferedWriter(f);
                    //System.out.println("correlation coefficient between\t"+ mirna +"\t"+ target +"\t"  + r);
                     brw.write(mirna +"\t"+ target + "\t" +r + "\n");
                     brw.flush();
                     brw.close();

                  }
            return r;
        }


            }

 public static void main(String[] args )throws IOException{
<<<<<<< HEAD
      BufferedReader br1 = new BufferedReader(new FileReader("10kb_up_down_gene_rep"));
        String str1;
        while((str1=br1.readLine())!=null)
        {   String str2=br1.readLine();
	    String[] a = str1.split("\t");
            String[] b = str2.split("\t");
	    

	 StringBuilder gh = new StringBuilder();
         StringBuilder gh1 = new StringBuilder();
=======

    

     if(args.length!=4)
     {
         corR = -1;
     }
     else
     {
         corR = Double.parseDouble(args[3]);
     }

      BufferedReader br1 = new BufferedReader(new FileReader(args[0]));
        String str1;
        while((str1=br1.readLine())!=null)
        {   String[] a = str1.split("\t");

             {


            BufferedReader br2 = new BufferedReader(new FileReader(args[1]));
        String str2;
        while((str2=br2.readLine())!=null)
        {
            String[] b = str2.split("\t");
        
           {
             // 
                 //if(a[0].equalsIgnoreCase(b[0]))
                 {
                     //System.out.println(seprate[0]+"\t"+b[0]);
                  StringBuilder gh = new StringBuilder();
                     StringBuilder gh1 = new StringBuilder();
>>>>>>> eef31af9f9e802e6552a63d7f2d7be03c5bdd5b5
                 for(int i=1;i<b.length;i++)
                    {
                                gh.append(b[i]).append("\t");
                    }

                     for(int i=1;i<a.length;i++)
                    {
                                gh1.append(a[i]).append("\t");
                    }
<<<<<<< HEAD
                    Correlations.corcoeff(gh.toString(), gh1.toString(),a[0],b[0],"correlation_bw_potato_gene_and_rep_mod_all_repeats");	

        }
br1.close();

}
}
=======
                    Correlations.corcoeff(gh.toString(), gh1.toString(),a[0],b[0],args[2],corR);
            }
            }
}br2.close();
        }
}br1.close();
    }

}
>>>>>>> eef31af9f9e802e6552a63d7f2d7be03c5bdd5b5

