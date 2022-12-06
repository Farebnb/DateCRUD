package com.cognizant.DateCRUD.controller;

import com.cognizant.DateCRUD.model.DateModel;
import com.cognizant.DateCRUD.repo.DateRepo;
import com.cognizant.DateCRUD.service.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;

@RestController
@RequestMapping("/date")
@CrossOrigin(origins = "*")
public class DateController {

    @Autowired
    private DateRepo dr;

    @Autowired
    private DateService ds;

    @Autowired
    private DateController(DateRepo dr, DateService ds){
        this.dr = dr;
        this.ds = ds;
    }

    @GetMapping("/")
    public ResponseEntity<DateModel> getByDate(@RequestParam String sqlDate){
        return new ResponseEntity<>(ds.getByDate(sqlDate), HttpStatus.ACCEPTED);

    }

    @GetMapping("/listingId")
    public ResponseEntity<List<DateModel>> getByListingId(@RequestParam int id){
        return new ResponseEntity<>(ds.getByListingId(id), HttpStatus.ACCEPTED);
    }

    @GetMapping("/userId")
    public ResponseEntity<List<DateModel>> getByUserId(@RequestParam int id){
        return new ResponseEntity<>(ds.getByUserId(id), HttpStatus.ACCEPTED);
    }

    @GetMapping("/available")
    public ResponseEntity<List<DateModel>> getAvailable(@RequestParam boolean available){
        return new ResponseEntity<>(ds.getByIsAvailable(available), HttpStatus.ACCEPTED);
    }

    @PostMapping("/book")
    public ResponseEntity<DateModel> bookDate(@RequestBody LinkedHashMap<String, String> body){
        return new ResponseEntity<>(ds.createDate(body.get("sqlDate"), Integer.parseInt(body.get("listingId")), Integer.parseInt(body.get("userId"))), HttpStatus.ACCEPTED);
    }

    @GetMapping("/delete")
    public ResponseEntity<DateModel> removeBooking(@RequestParam String sqlDate){
        DateModel d = new DateModel(java.sql.Date.valueOf(sqlDate), 0, 0,  true);
        return new ResponseEntity<>(ds.updateDate(d), HttpStatus.ACCEPTED);
    }




}
