package com.example.api.custom.query2.controllers;

import com.example.api.custom.query2.entities.Fligth;
import com.example.api.custom.query2.entities.Status;
import com.example.api.custom.query2.repositories.FligthRepository;
import com.example.api.custom.query2.service.FligthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fligths")
public class FligthController {

    @Autowired
    FligthRepository fligthRepository;

    @Autowired
    FligthService fligthService;

    @PostMapping
    public void createAll(@RequestParam(required = false) String n) {
        fligthService.createFligth(n);
    }

    @GetMapping
    public List<Fligth> getAll() {
        List<Fligth> fligths = fligthRepository.findAll();
        return fligths;
    }

    @GetMapping("/order")
    public Page<Fligth> pageFligth(@RequestParam(required = false) Optional<Integer> page, @RequestParam(required = false) Optional<Integer> size){
        return fligthService.pageFligth(page,size);
    }

    @GetMapping("/onetime")
    public List<Fligth> getFligthOneTime(){
        return fligthService.getFligthOneTime();
    }


    @GetMapping("/status")
    public List<Fligth> findByStatus(@RequestParam(required = false) Status status,@RequestParam(required = false) Status status1){
        return fligthRepository.findByStatus(status,status1);
    }
}
