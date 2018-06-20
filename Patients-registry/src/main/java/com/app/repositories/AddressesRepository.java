package com.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.models.Address;

@Repository
public interface AddressesRepository extends JpaRepository<Address, Long> {

}
