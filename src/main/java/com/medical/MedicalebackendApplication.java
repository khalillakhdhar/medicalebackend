package com.medical;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.medical.entities.Genre;
import com.medical.entities.Maladie;
import com.medical.entities.Medicament;
import com.medical.entities.Profile;
import com.medical.entities.Rappel;
import com.medical.entities.User;
import com.medical.services.MaladieService;
import com.medical.services.MedicamentService;
import com.medical.services.RappelService;
import com.medical.services.UserService;
import com.medical.services.implementations.MaladieServiceImplement;

@SpringBootApplication
@EnableJpaAuditing
public class MedicalebackendApplication implements CommandLineRunner {

	@Autowired
	UserService userService;
	@Autowired
	MaladieService maladieService;
	@Autowired
	MedicamentService medicamentService;
	@Autowired
	RappelService rappelService;
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
		Maladie m=new Maladie("grippe", "aigue","normale", "saisoniaire", null, null, null, null);
		Maladie maladie=maladieService.addOneMaladie(m, us.getId());
		Medicament medicament=new Medicament("gripex", "anti toux", null, null, null, null);
		Medicament m1=medicamentService.addOneMedicament(medicament, maladie.getId());
		Rappel rappel1=new Rappel("gripex prise 1", null, null, "1 dose");
		Rappel rappel2=new Rappel("gripex prise 2", null, null, "1 dose");
		rappelService.addOneRappel(rappel1, m1.getId());
		rappelService.addOneRappel(rappel2, m1.getId());
	
		
		
		
	}

}
