package com.cognizant.DateCRUD.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DateModel {

    @Id
    @Column(unique = true)
    private java.sql.Date sqlDate;

    @Column(name="LISTINGID")
    private int listingId;

    @Column(name="USERID")
    private int userId;

    @Column
    private boolean available;
}
