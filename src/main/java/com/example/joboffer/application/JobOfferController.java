package com.example.joboffer.application;

import com.example.joboffer.domain.JobOffer;
import com.example.joboffer.domain.JobOfferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/offer")
public class JobOfferController {

    private final JobOfferService jobOfferService;

    public JobOfferController(JobOfferService jobOfferService) {
        this.jobOfferService = jobOfferService;
    }

    @GetMapping
    ResponseEntity<List<JobOfferResponse>> getValidOffers() {
        List<JobOfferResponse> validOffers = jobOfferService.getValidOffers()
                .stream()
                .map(JobOffer::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(validOffers);
    }
}
