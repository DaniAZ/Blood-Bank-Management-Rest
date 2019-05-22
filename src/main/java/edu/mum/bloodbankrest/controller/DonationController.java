package edu.mum.bloodbankrest.controller;


import edu.mum.bloodbankrest.domain.Donation;
import edu.mum.bloodbankrest.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/donations")
@RestController
public class DonationController {
    @Autowired
    private DonationService donationService;

    @GetMapping({"","/all"})
    public List<Donation> getAllDonations(Model model) {
        return  (List<Donation>)donationService.findAll();

    }

    @GetMapping("/{id}")
    public Donation getDonationById( @PathVariable("id") Long donationId) {

        return donationService.findOne(donationId);
    }



    @PostMapping("/add")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void processAddNewDonationForm(@RequestBody Donation donationToBeAdded ) {
         donationService.save(donationToBeAdded);

    }
}
