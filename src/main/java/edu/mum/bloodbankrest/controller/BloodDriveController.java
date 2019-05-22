package edu.mum.bloodbankrest.controller;

import edu.mum.bloodbankrest.domain.BloodDrive;
import edu.mum.bloodbankrest.service.BloodDriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;



@RestController
@RequestMapping("/bloodDrives")
public class BloodDriveController {
    @Autowired
    private BloodDriveService bloodDriveService;

    @GetMapping({"","/all"})
    public List<BloodDrive> getAllBloodDrive(Model model) {
        return  (List<BloodDrive>)bloodDriveService.findAll();

    }

    @GetMapping("/{id}")
    public BloodDrive getBloodDriveById( @PathVariable("id") Long bloodDriveId) {

        return bloodDriveService.findOne(bloodDriveId);
    }


   // @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/add")
    //@RequestMapping(value = "/add", method = RequestMethod.POST)
   public String processAddNewBloodDriveForm(@RequestBody  BloodDrive bloodDriveToBeAdded ) {
        System.out.println("post method");
       bloodDriveService.save(bloodDriveToBeAdded);
       return "success";
    }

}
