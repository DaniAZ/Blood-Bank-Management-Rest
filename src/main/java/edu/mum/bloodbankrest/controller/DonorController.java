package edu.mum.bloodbankrest.controller;


import edu.mum.bloodbankrest.domain.BloodType;
import edu.mum.bloodbankrest.domain.Donation;
import edu.mum.bloodbankrest.domain.Donor;
import edu.mum.bloodbankrest.domain.Total;
import edu.mum.bloodbankrest.service.DonationService;
import edu.mum.bloodbankrest.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/donors")
@RestController
public class DonorController {

    @Autowired
    private DonorService donorService;

    @GetMapping({"","/all"})
    public List<Donor> getAllDonors(Model model) {
        return  (List<Donor>)donorService.findAll();

    }

    @GetMapping("/{id}")
    public Donor getDonorById(@PathVariable("id") Long donorId) {
         System.out.println(donorId);
        return donorService.findOne(donorId);
    }

    @GetMapping("/home")
    public @ResponseBody List<Total> getDonorByBloodType() {

         return  donorService.findAvailableBloodType();

    }



    @PostMapping("/add")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void processAddNewDonorForm(@RequestBody Donor donorToBeAdded ) {
        donorService.save(donorToBeAdded);

    }
}
