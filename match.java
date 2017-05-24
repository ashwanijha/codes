
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Ashwani Jha
 * @date created 24-May-2017
 * javac -cp ".:guava-19.0.jar" match.java
 * java -cp ".:guava-19.0.jar" match test_file_for_cor.txt test_file.txt matched_result.txt
 */
public class match {
    
    public static void main(String[] args) throws IOException{
     
      BufferedWriter bw = new BufferedWriter(new FileWriter(args[2]));
        Map<String,String> data = new HashMap<>();

	try (BufferedReader br = new BufferedReader(new FileReader(args[1]))) {
        String str;
        while((str = br.readLine())!=null)
        {
	    String[] a = str.split("\t");
	    data.put(a[0], str);
	}
        }


	Multimap<String,String> data1 = ArrayListMultimap.create();
        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
        String str;
        while((str = br.readLine())!=null)
        {
	    int match =0;
	    String[] a = str.split("\t");
            if(data.containsKey(a[0]))
	    {
		bw.write(str+"\t"+data.get(a[0])+"\n");
	    }
		    }
	   }

	
	
        bw.close();
}

}

