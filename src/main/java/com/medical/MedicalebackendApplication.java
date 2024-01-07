package com.medical;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.medical.entities.Genre;
import com.medical.entities.Profile;
import com.medical.entities.User;
import com.medical.services.UserService;

@SpringBootApplication
@EnableJpaAuditing
public class MedicalebackendApplication implements CommandLineRunner {

	@Autowired
	UserService userService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(MedicalebackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User user=new User("khalil", "lakhdhar", "test@gmail.com", "azerty12345", 33, null,null, Genre.Homme);
		User us=userService.addOneUser(user);
		Profile profile=new Profile(0, "aucune", "Gabés", "ok", "30999222", null);
		userService.AssignProfileToUser(us.getId(), profile);
		profile.setPhoto("https://avatars.githubusercontent.com/u/12435165?v=4");
		userService.updateProfile(profile, us.getId());
		
	}

}
