package com.example.joboffer.application;

import com.example.joboffer.domain.Category;
import com.example.joboffer.domain.UserName;
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
