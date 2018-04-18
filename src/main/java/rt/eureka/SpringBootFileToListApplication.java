package rt.eureka;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * https://memorynotfound.com/spring-boot-passing-command-line-arguments-example/
 * @author rafal
 *
 */
@SpringBootApplication
public class SpringBootFileToListApplication implements ApplicationRunner{

	private static final Log log = LogFactory.getLog(SpringBootFileToListApplication.class);

	@Autowired
	private FileReader fr;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootFileToListApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		if (args.getNonOptionArgs().size() ==1){
//findFirst zwraca Optional. get pobiera wartosc z Optinal<String>
//			https://examples.javacodegeeks.com/core-java/util/optional/java-8-optional-example/
			String fileName = args.getNonOptionArgs().stream().findFirst().get(); 
			log.info("***param :" + fileName);
			fr.readFile(fileName);
		}
	}
	
	
}
