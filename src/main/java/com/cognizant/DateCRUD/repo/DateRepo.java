package com.cognizant.DateCRUD.repo;

import com.cognizant.DateCRUD.model.DateModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DateRepo extends JpaRepository<DateModel, Integer> {

    DateModel findBySqlDate(java.sql.Date sqlDate);

    List<DateModel> findByListingId(int listingId);

    List<DateModel> findByUserId(int userId);

    List<DateModel> findByAvailable(boolean available);

}
