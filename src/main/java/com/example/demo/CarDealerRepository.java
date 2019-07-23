package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface CarDealerRepository extends CrudRepository<CarDealer, Long> {
    Iterable<CarDealer> findAllByOwner_Id(Long owner_Id);
}
