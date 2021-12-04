package com.example.joboffer.domain;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class JobOfferService {
    private final JobOfferRepository jobOfferRepository;

    public JobOfferService(JobOfferRepository jobOfferRepository) {
        this.jobOfferRepository = jobOfferRepository;
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
