package com.tokyo.wayon.repositories;

import com.tokyo.wayon.model.transfer.Transfer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {
    List<Transfer> findAllBySenderId(UUID id);

}