package com.example.joboffer.application;

import com.example.joboffer.domain.Category;
import com.example.joboffer.domain.JobOffer;
import com.example.joboffer.domain.JobOfferService;
import com.example.joboffer.domain.UserName;
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

    @PostMapping
    public ResponseEntity<Void> saveOffer(@RequestBody JobOfferRequest offerRequest) {
        jobOfferService.saveOffer(offerRequest);

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    ResponseEntity<List<JobOfferResponse>> getValidOffers(@RequestParam(required = false) UserName employerName,
                                                          @RequestParam(required = false) Category category) {
        List<JobOfferResponse> validOffers = jobOfferService.getValidOffers(employerName, category)
                .stream()
                .map(JobOffer::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(validOffers);
    }
}
