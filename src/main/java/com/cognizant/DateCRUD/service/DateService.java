package com.cognizant.DateCRUD.service;

import com.cognizant.DateCRUD.model.DateModel;
import com.cognizant.DateCRUD.repo.DateRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DateService {

    private final DateRepo dr;

    public DateService(DateRepo dr) {
        this.dr = dr;
    }

    public DateModel getByDate(String sqlDate) {
        return dr.findBySqlDate(java.sql.Date.valueOf(sqlDate));
    }

    public List<DateModel> getByListingId(int listingId) {
        return dr.findByListingId(listingId);
    }

    public List<DateModel> getByUserId(int userId) {
        return dr.findByUserId(userId);
    }



    public List<DateModel> getByIsAvailable(boolean available) {
        return dr.findByAvailable(available);
    }


    public DateModel createDate(String sqlDate, int listingId, int userId) {
        DateModel d = new DateModel(java.sql.Date.valueOf(sqlDate), listingId, userId, false);

        return dr.save(d);
    }

    public DateModel updateDate(DateModel d) {
        return dr.saveAndFlush(d);
    }

}
