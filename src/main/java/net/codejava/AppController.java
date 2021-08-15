package net.codejava;

import java.util.List;

import net.codejava.Donar.Donation;
import net.codejava.Donar.DonationRepo;
import net.codejava.Donar.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AppController {

	@Autowired
	private UserRepository userRepo;

     @Autowired
	private DonationService service;


	
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		
		return "signup_form";
	}


	@PostMapping("/process_register")
	public String processRegister(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		userRepo.save(user);
		SNSPublisher.publishMessage("Welcome!!! to Findo- A fund Rasisng Platform  ", "Mr/Mrs: "+user.getFirstName()+" "+user.getLastName()+" has signed up for donation ");
		return "register_success";
	}



	@GetMapping("/users")
	public String listUsers(Model model) {
		List<User> listUsers = userRepo.findAll();

		model.addAttribute("listUsers", listUsers);
		return "users";
	}

	@GetMapping("/product")
	public String list(Model model){
		List<Donation> listDonations =service.listAll();
		model.addAttribute("listDonations",listDonations);
		return "users";
//        return service.listAll();
	}

	@GetMapping("/log")
	public String campaignPage(Model model) {
		//User u = new User();


		//SNSPublisher.publishMessage("Thank you for Donating amount  ", "Mr/Mrs: "+"Donation received");

		return "homepage";
	}
}
