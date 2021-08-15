package net.codejava.Donar;

import net.codejava.Donar.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationRepo extends JpaRepository<Donation,Long> {
}
