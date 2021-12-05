package com.example.joboffer.joboffer.domain;

import com.example.joboffer.joboffer.application.JobOfferResponse;
import com.example.joboffer.sharedkernell.UserName;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JobOffer jobOffer = (JobOffer) o;

        return id.equals(jobOffer.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
