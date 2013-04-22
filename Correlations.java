
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author ashwani
 */
public class Correlations {
public static void main(String[] args) throws IOException
    {
    ArrayList<String> list = new ArrayList<String>();


 BufferedWriter bw = new BufferedWriter(new FileWriter(args[2]));
    BufferedReader br = new BufferedReader(new FileReader(args[0]));
    String str;
    while((str=br.readLine())!=null)
    {
  //  if(str.contains(">"))
    {
       
   // 
    String[] d = str.split("\t");
 StringBuilder gh = new StringBuilder();
              for(int ak1=1;ak1 < d.length;ak1++)
                    {
                        gh.append(d[ak1]).append("\t");
                    }

    BufferedReader br1 = new BufferedReader(new FileReader(args[1]));
    String str1;
    while((str1=br1.readLine())!=null)
    {
// System.out.println(str);
        String[] b = str1.split("\t");
          
      if(d[0].equals(b[0]))  {

         StringBuilder gh1 = new StringBuilder();
             for(int ak1=1;ak1 < b.length;ak1++)
                    {
                       gh1.append(b[ak1]).append("\t");
                    }

                 //   temp.corcoeff(gh.toString(), gh1.toString(),zz[0],ak[0]);
                 cor.corcoeff(gh.toString(), gh1.toString(), d[0], b[0],str);
             }
         }br1.close();
        }


    }
    
    }





  public static void corcoeff(String str,String argument, String mirna, String target,String strings) throws IOException

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
              //  System.out.println(a1.length+"\t"+a.length);

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
     if( r >= 0.5 || r<= -0.5)
               {
      FileWriter f  = new FileWriter("exp_cor_repeat_tf",true);
                     BufferedWriter brw = new BufferedWriter(f);
                    //System.out.println("correlation coefficient between\t"+ mirna +"\t"+ target +"\t"  + r);
                     brw.write(mirna +"\t"+ target + "\t" +r + "\n");
                     brw.flush();
                     brw.close();

                  }

            }
}










