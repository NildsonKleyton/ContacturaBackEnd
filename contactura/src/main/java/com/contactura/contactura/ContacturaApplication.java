package com.contactura.contactura;

//import java.util.stream.LongStream;

//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;

//import com.contactura.contactura.model.Contactura;
//import com.contactura.contactura.repository.ContacturaRepository;

@SpringBootApplication
public class ContacturaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContacturaApplication.class, args);
	}
	
//	@Bean
//	CommandLineRunner init(ContacturaRepository repository) {
//		return args ->{
////			para o casso de ser necessario limpar o banco
////			repository.deleteAll();
//			LongStream.range(1, 100)
//			.mapToObj(id -> {
//				Contactura c = new Contactura();
//				c.setName("Contactura User" + id);
//				c.setPhone("(081) 9"+id+id+id+id+'-'+id+id+id+id);
//				c.setEmail("contactura_user"+ id + "@contactura");
//				return c;
//			}).map(record -> repository.save(record))
//			.forEach(System.out::println);
//		};
//	}

}
