package com.example.joboffer;

import com.example.joboffer.domain.Category;
import com.example.joboffer.domain.JobOffer;
import com.example.joboffer.domain.JobOfferRepository;
import com.example.joboffer.domain.UserName;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class InitialRunner implements ApplicationRunner {

    private final JobOfferRepository jobOfferRepository;

    public InitialRunner(JobOfferRepository jobOfferRepository) {
        this.jobOfferRepository = jobOfferRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<JobOffer> offers = new ArrayList<>();
        offers.add(new JobOffer(Category.IT, LocalDate.now(), LocalDate.now().plusDays(5), new UserName("Mary")));
        offers.add(new JobOffer(Category.OFFICE, LocalDate.now().minusDays(2), LocalDate.now(), new UserName("John")));
        offers.add(new JobOffer(Category.IT, LocalDate.now().minusDays(5), LocalDate.now().minusDays(2), new UserName("Patric")));

        jobOfferRepository.saveAll(offers);
    }
}
