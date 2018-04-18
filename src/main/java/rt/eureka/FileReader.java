package rt.eureka;

/**
 *
 

http://www.java2s.com/Tutorials/Java/java.util.stream/Collectors/Collectors.toList_.htm

 
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

 
@Service
public class FileReader {

 

      

       private static final String separator = ",";

      private static final Log log = LogFactory.getLog(FileReader.class);
       /**

       * http://blog.codeleak.pl/2014/05/parsing-file-with-stream-api-in-java-8.html?m=1
       * https://www.mkyong.com/java8/java-8-stream-read-a-file-line-by-line/

       * @param FileName

       * @return
     * @throws IOException 

       */

       public List<Long> readFile(String FileName) throws IOException{

             BufferedReader br ;
			
				br = new BufferedReader(Files.newBufferedReader(Paths.get(FileName)));
			

             List<List<String>> listaList= br.lines().map(line -> Arrays.asList( line.split(separator))).collect(Collectors.toList());

             List<Long> calaLista  = listaList.stream().flatMap(lista -> lista.stream()).map( object -> new Long(object.trim())).collect(Collectors.toList());

             log.info(calaLista.toString());
             
             return calaLista;
             
             

       }

}

 
