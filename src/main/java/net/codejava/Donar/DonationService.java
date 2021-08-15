package net.codejava.Donar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class DonationService {
    @Autowired
    DonationRepo service;

    public List<Donation> listAll(){
        return service.findAll();
    }
    public void save(Donation donation){
        service.save(donation);
    }

    public Donation get(Long id){
        return service.findById(id).get();
    }
}
