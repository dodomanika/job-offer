package com.example.joboffer.application;

import com.example.joboffer.domain.Category;
import com.example.joboffer.domain.UserName;

public class JobOfferResponse {
    private final Category category;
    private final UserName employerName;

    public JobOfferResponse(Category category, UserName employerName) {
        this.category = category;
        this.employerName = employerName;
    }
}
