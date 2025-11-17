package JPA.MapDTOtoTable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("JPA.MapDTOtoTable.Entity")
public class MapDtOtoTableApplication {

	public static void main(String[] args) {
		SpringApplication.run(MapDtOtoTableApplication.class, args);
	}

}
