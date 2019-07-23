package com.example.demo;


import javax.persistence.*;
import java.util.Set;

@Entity
    public class Dealer {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;

        private String personName;

        @OneToMany(mappedBy = "dealer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
        private Set<Car> cars;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }
}
