package com.example.joboffer.joboffer.application;

import com.example.joboffer.joboffer.domain.Category;
import com.example.joboffer.joboffer.domain.JobOffer;
import com.example.joboffer.joboffer.domain.JobOfferService;
import com.example.joboffer.joboffer.domain.UserName;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/offer")
public class JobOfferController {

    private final JobOfferService jobOfferService;

    public JobOfferController(JobOfferService jobOfferService) {
        this.jobOfferService = jobOfferService;
    }

    //Todo: offer created by user: add user id in header and retrieve employerName instead of having it in request body
    @PostMapping
    public ResponseEntity<Void> saveOffer(@RequestBody JobOfferRequest offerRequest) {
        jobOfferService.saveOffer(offerRequest);

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<JobOfferResponse>> getValidOffers(@RequestParam(required = false) UserName employerName,
                                                          @RequestParam(required = false) Category category) {
        List<JobOfferResponse> validOffers = jobOfferService.getValidOffers(employerName, category)
                .stream()
                .map(JobOffer::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(validOffers);
    }
}
