package ma.ensa.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ma.ensa.entities.User;
import ma.ensa.repositories.UserRepository;

import java.util.Arrays;
import java.util.List;

//@Service
public class DbInit implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	@Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public void run(String... args) {
        // Delete all
        this.userRepository.deleteAll();

        // Crete users
        User dan = new User("dan",passwordEncoder.encode("dan123"),"USER","");
        User admin = new User("admin",passwordEncoder.encode("admin123"),"ADMIN","ACCESS_TEST1,ACCESS_TEST2");
        User manager = new User("manager",passwordEncoder.encode("manager123"),"MANAGER","ACCESS_TEST1");

        List<User> users = Arrays.asList(dan,admin,manager);

        // Save to db
        this.userRepository.saveAll(users);
    }
}
