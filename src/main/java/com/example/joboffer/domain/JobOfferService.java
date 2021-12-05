package com.example.joboffer.domain;

import com.example.joboffer.application.JobOfferRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class JobOfferService {
    private final JobOfferRepository jobOfferRepository;

    public JobOfferService(JobOfferRepository jobOfferRepository) {
        this.jobOfferRepository = jobOfferRepository;
    }

    public void saveOffer(JobOfferRequest offerRequest) {
        JobOffer offer = offerRequest.toEntity();
        jobOfferRepository.save(offer);
    }

    //TODO: Use JpaSpecificationExecutor
    public List<JobOffer> getValidOffers(UserName name, Category category) {
        LocalDate today = LocalDate.now();

        if (name != null) {
            return jobOfferRepository.findAllByEmployerNameAndBetweenStartDateAndEndDate(today, name);
        }
        if (category != null) {
            return jobOfferRepository.findAllByCategoryAndBetweenStartDateAndEndDate(today, category);
        }
        return jobOfferRepository.findAllBetweenStartDateAndEndDate(today);
    }
}
