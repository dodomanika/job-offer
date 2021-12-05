package com.example.joboffer.joboffer.application;

import com.example.joboffer.joboffer.domain.Category;
import com.example.joboffer.joboffer.domain.JobOffer;
import com.example.joboffer.joboffer.domain.UserName;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
public class JobOfferRequest implements Serializable {
    private final Category category;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final UserName employerName;

    public JobOfferRequest(Category category, LocalDate startDate, LocalDate endDate, UserName employerName) {
        this.category = category;
        this.startDate = startDate;
        this.endDate = endDate;
        this.employerName = employerName;
    }

    public JobOffer toEntity() {
        return new JobOffer(category, startDate, endDate, employerName);
    }
}
