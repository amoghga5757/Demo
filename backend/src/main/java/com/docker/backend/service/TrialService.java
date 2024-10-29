package com.docker.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docker.backend.dto.TrialResponse;
import com.docker.backend.model.TrialTable;
import com.docker.backend.repository.TrialRepository;

@Service
public class TrialService {

    @Autowired
    private TrialRepository trialRepository;

    public TrialResponse addObj(TrialResponse data) {
        TrialResponse trialResponse = new TrialResponse();
        try {
            // Add logic to add object to database
            TrialTable trial = new TrialTable();
            trial.setId(data.getId());
            trial.setName(data.getName());
            trial.setPhone(data.getPhone());
            trialRepository.save(trial);
            trialResponse.setMessage("Data saved successfully");
            trialResponse.setStatusCode(200);
        } catch (Exception e) {
            trialResponse.setMessage(e.getMessage());
            trialResponse.setStatusCode(500);
        }
        return trialResponse;
    }

    public TrialResponse getObj(Integer id) {
        TrialResponse trialResponse = new TrialResponse();
        try {
            Optional<TrialTable> resp = trialRepository.findById(id);
            if (resp.isPresent()) {
                TrialTable result = resp.get();
                trialResponse.setId(result.getId());
                trialResponse.setName(result.getName());
                trialResponse.setPhone(result.getPhone());
                trialResponse.setMessage("Data retrieved successfully");
                trialResponse.setStatusCode(200);
            } else {
                trialResponse.setMessage("No result present");
                trialResponse.setStatusCode(200);
            }
        } catch (Exception e) {
            trialResponse.setMessage(e.getMessage());
            trialResponse.setStatusCode(500);
        }
        return trialResponse;
    }

}
