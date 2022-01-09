package com.ndgndg91.test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import javax.persistence.LockModeType;
import java.util.Optional;

public interface PessimisticTestRepository extends JpaRepository<PessimisticTest, Long> {

    @Lock(value = LockModeType.PESSIMISTIC_WRITE)
    Optional<PessimisticTest> findById(final long id);
}