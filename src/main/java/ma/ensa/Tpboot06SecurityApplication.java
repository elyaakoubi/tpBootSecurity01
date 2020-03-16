package ma.ensa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.userdetails.UserDetailsService;

import ma.ensa.entities.User;


@SpringBootApplication
public class Tpboot06SecurityApplication 
{
	
	public static void main(String[] args) {
		SpringApplication.run(Tpboot06SecurityApplication.class, args);
	}

}
