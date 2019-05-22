package edu.mum.bloodbankrest.controller;


import edu.mum.bloodbankrest.domain.Donor;
import edu.mum.bloodbankrest.domain.Hospital;
import edu.mum.bloodbankrest.service.DonorService;
import edu.mum.bloodbankrest.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/hospitals")
@RestController
public class HospitalController {
    @Autowired
    private HospitalService hospitalService;

    @GetMapping({"","/all"})
    public List<Hospital> getAllHospitals(Model model) {
        return  hospitalService.findAll();

    }

    @GetMapping("/{id}")
    public Hospital getHospitalById( @PathVariable("id") Long hospitalId) {

        return hospitalService.findOne(hospitalId);
    }



    @PostMapping("/add")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void processAddHospitalForm(@RequestBody Hospital hospitalToBeAdded ) {
        hospitalService.save(hospitalToBeAdded);

    }
}
