package com.docker.backend.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.docker.backend.dto.TrialResponse;
import com.docker.backend.service.TrialService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin
@RestController
public class Trial {

    @Autowired
    private TrialService trialServices;

    @GetMapping("/")
    public String tempo() {
        return "Hello,";
    }

    @PostMapping("/add")
    public ResponseEntity<TrialResponse> postMethodName(@RequestBody TrialResponse data) {
        return ResponseEntity.ok(trialServices.addObj(data));
    }

    @GetMapping("/give/{id}")
    public ResponseEntity<TrialResponse> getMethodName(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(trialServices.getObj(id));
    }

}
