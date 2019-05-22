package edu.mum.bloodbankrest.controller;

import edu.mum.bloodbankrest.domain.Hospital;
import edu.mum.bloodbankrest.domain.Request;
import edu.mum.bloodbankrest.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/requests")
@RestController
public class RequestController {

    @Autowired
    private RequestService requestService;
    @GetMapping({"","/all"})
    public List<Request> getAllRequest(Model model) {
        return  (List<Request>)requestService.findAll();

    }

    @GetMapping("/{id}")
    public Request getRequestById( @PathVariable("id") Long hospitalId) {

        return requestService.findOne(hospitalId);
    }



    @PostMapping("/add")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void processAddRequestForm(@RequestBody Request requestToBeAdded ) {
        requestService.save(requestToBeAdded);

    }
}
