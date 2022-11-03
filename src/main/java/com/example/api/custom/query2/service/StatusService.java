package com.example.api.custom.query2.service;

import com.example.api.custom.query2.entities.Status;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class StatusService {

    public Status randomStatus(){
        Random r = new Random();
        return Status.values()[r.nextInt(Status.values().length)];
    }
}
