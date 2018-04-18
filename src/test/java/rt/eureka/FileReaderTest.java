package rt.eureka;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileReaderTest {
	
	private static final String fileName = "src/test/resource/lista.txt";

	@Autowired
	private FileReader fileReader;
	
	@Test
	public void testFileReader() throws IOException {
		assertThat( fileReader.readFile(fileName)).isNotNull();
		List<Long> lista =fileReader.readFile(fileName);
		lista.stream().forEach(el -> System.out.println(el));
	}

}
