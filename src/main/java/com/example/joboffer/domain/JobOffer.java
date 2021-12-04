package com.example.joboffer.domain;

import com.example.joboffer.application.JobOfferResponse;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class JobOffer {

    @Id
    @GeneratedValue
    private Long id;

    private Category category;
    private LocalDate startDate;
    private LocalDate endDate;

    @Embedded
    private UserName employerName;

    public JobOffer(Category category, LocalDate startDate, LocalDate endDate, UserName employerName) {
        this.category = category;
        this.startDate = startDate;
        this.endDate = endDate;
        this.employerName = employerName;
    }

    /*For JPA only*/
    protected JobOffer() {}

    public JobOfferResponse toDto() {
        return new JobOfferResponse(category, employerName);
    }
}
