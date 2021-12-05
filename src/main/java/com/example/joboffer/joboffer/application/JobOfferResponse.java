package com.example.joboffer.joboffer.application;

import com.example.joboffer.joboffer.domain.Category;
import com.example.joboffer.sharedkernell.UserName;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class JobOfferResponse implements Serializable {
    private final Category category;
    private final UserName employerName;

    public JobOfferResponse(Category category, UserName employerName) {
        this.category = category;
        this.employerName = employerName;
    }
}
