package com.example.api.custom.query2.service;

import com.example.api.custom.query2.entities.Fligth;
import com.example.api.custom.query2.entities.Status;
import com.example.api.custom.query2.repositories.FligthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.*;

@Service
public class FligthService {

    @Autowired
    FligthRepository fligthRepository;
    @Autowired
    StatusService statusService;

    public void createFligth(@RequestParam(required = false) String n) {
        Random random = new Random();
        if (n != null) {
            int n1 = Integer.parseInt(n);
            for (int i = 0; i < n1; i++) {
                String randomAttributeFligth = random.ints(10, 97, 122)
                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                        .toString();
                Fligth fligth = fligthRepository.save(new Fligth(randomAttributeFligth, randomAttributeFligth, randomAttributeFligth, statusService.randomStatus()));
            }
        } else {
            for (int i = 0; i < 100; i++) {
                String randomAttributeFligth = random.ints(10, 97, 122)
                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                        .toString();
                Fligth fligth = fligthRepository.save(new Fligth(randomAttributeFligth, randomAttributeFligth, randomAttributeFligth, statusService.randomStatus()));
            }
        }
    }

    public Page<Fligth> pageFligth(@RequestParam(required = false) Optional<Integer> page, @RequestParam(required = false) Optional<Integer> size) {
        Pageable pageable = null;
        if (page.isPresent() && size.isPresent()) {
            Sort sort = Sort.by(new Sort.Order(Sort.Direction.ASC, "fromAirport"));
            pageable = PageRequest.of(page.get(), size.get(), sort);
            Page<Fligth> fligthPage = fligthRepository.findAll(pageable);
            return fligthPage;
        } else {
            Page<Fligth> fligthPage1 = Page.empty();
            return fligthPage1;
        }
    }

    public List<Fligth> getFligthOneTime() {
        List<Fligth> fligths = fligthRepository.findAll();
        List<Fligth> fligthsOneTime = new ArrayList<>();
        for (int i = 0; i < fligths.size(); i++) {
            if (fligths.get(i).getStatus() == Status.ONTIME) {
                fligthsOneTime.add(fligths.get(i));
            }
        }
        return fligthsOneTime;
    }

    public List<Fligth> findByStatus(Status status, Status status1) {
        List<Fligth> fligths= fligthRepository.findByStatus(status, status1);
        return fligths;
    }
}

