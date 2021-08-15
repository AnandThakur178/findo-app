package net.codejava;

import net.codejava.Donar.Donation;
import net.codejava.Donar.DonationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private DonationRepo service;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return new CustomUserDetails(user);
	}
	public void saveUser(User user){
		userRepo.save(user);

	}




}
