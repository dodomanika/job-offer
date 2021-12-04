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
    /*public void saveJobOffer(JobOfferDTO jobOfferDTO) {
        return new JobOffer();
    }*/

    public List<JobOffer> getValidOffers() {
        LocalDate today = LocalDate.now();
        return jobOfferRepository.findAllBetweenStartDateAndEndDate(today);
    }

    public List<JobOffer> getValidOffersByEmployerName(UserName name) {
        LocalDate today = LocalDate.now();
        return jobOfferRepository.findAllByEmployerNameAndBetweenStartDateAndEndDate(today, name);
    }

    /*public List<JobOffer> getValidOffersByCategory(Category category) {
        LocalDate today = LocalDate.now();
        return jobOfferRepository.findAllByStartDateBeforeAndEndDateAfterAndCategory(today, category);
    }*/
}
