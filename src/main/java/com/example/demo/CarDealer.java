package com.example.demo;


import javax.persistence.*;

@Entity
public class CarDealer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Dealer dealer;
    @ManyToOne
    private Car car;
    public CarDealer(){

        dealer=new Dealer();
        car=new Car();
    }

    public CarDealer(Dealer dealer, Car car){
        this.car=car;
        this.dealer=dealer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
