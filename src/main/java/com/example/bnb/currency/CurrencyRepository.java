package com.example.bnb.currency;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CurrencyRepository extends JpaRepository<Currency, Long> {

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Currency")
    void deleteAllData();

    @Modifying
    @Transactional
    @Query(value = "ALTER SEQUENCE currency_id_seq RESTART WITH 1", nativeQuery = true)
    void resetIdSequence();
}

