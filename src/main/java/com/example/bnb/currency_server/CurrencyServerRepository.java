package com.example.bnb.currency_server;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CurrencyServerRepository extends JpaRepository<CurrencyFromServer, Long> {

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM CurrencyFromServer")
    void deleteAllData();

    @Modifying
    @Transactional
    @Query(value = "ALTER SEQUENCE currencyfromserver_id_seq RESTART WITH 1", nativeQuery = true)
    void resetIdSequence();

}
