package com.example.thimodule4.controller;

import com.example.thimodule4.model.City;
import com.example.thimodule4.model.Nation;
import com.example.thimodule4.service.nation.INationService;
import com.example.thimodule4.service.nation.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/nation")
public class NationController {

    @Autowired
    private INationService nationService;

    @GetMapping("/list")
    public ResponseEntity<Iterable<Nation>> findAll(){
        return new ResponseEntity<>(nationService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Nation> create(@RequestBody Nation nation){
        nationService.save(nation);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Nation> deleteBookById(@PathVariable Long id) {
        nationService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Nation> updateBookById(@RequestBody Nation nation) {
        nationService.save(nation);
        return new ResponseEntity<>(nation, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Nation> findBookById(@PathVariable Long id) {

        return new ResponseEntity<>(nationService.findById(id).get(), HttpStatus.OK);
    }
}
