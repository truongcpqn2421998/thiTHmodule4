package com.example.thimodule4.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "nation_id")
    private Nation nation;

    private double area;

    private Long population;

    private double gdp;

    private String description;


}
