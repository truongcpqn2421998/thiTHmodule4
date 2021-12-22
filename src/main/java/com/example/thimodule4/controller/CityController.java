package com.example.thimodule4.controller;

import com.example.thimodule4.model.City;
import com.example.thimodule4.service.city.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/city")
public class CityController {
    @Autowired
    private ICityService cityService;

    @GetMapping("/list")
    public ResponseEntity<Iterable<City>> findAll(){
        return new ResponseEntity<>(cityService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<City> deleteBookById(@PathVariable Long id) {
        cityService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<City> create(@RequestBody City city){
        cityService.save(city);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<City> updateBookById(@RequestBody City city) {
        cityService.save(city);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<City> findBookById(@PathVariable Long id) {

        return new ResponseEntity<>(cityService.findById(id).get(), HttpStatus.OK);
    }
}
