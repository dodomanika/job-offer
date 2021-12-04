package com.example.joboffer.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface JobOfferRepository extends JpaRepository<JobOffer, Long> {

    @Query(value = "from JobOffer where :date between startDate and endDate")
    List<JobOffer> findAllBetweenStartDateAndEndDate(@Param("date") LocalDate date);

    @Query(value = "from JobOffer where :date between startDate and endDate and employerName = :employerName")
    List<JobOffer> findAllByEmployerNameAndBetweenStartDateAndEndDate(@Param("date") LocalDate date,
                                                     @Param("employerName") UserName employerName);

    @Query(value = "from JobOffer where :date between startDate and endDate and category = :category")
    List<JobOffer> findAllByCategoryAndBetweenStartDateAndEndDate(@Param("date") LocalDate date,
                                                                  @Param("category") Category category);
}
