package com.ndgndg91.test;

import lombok.RequiredArgsConstructor;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TestService {

    private final OptimisticTestRepository optimisticTestRepository;
    private final PessimisticTestRepository pessimisticTestRepository;

    @Retryable(maxAttempts = 5)
    public void minus(final long amount) {
        final var test = optimisticTestRepository.findById(1L).orElseThrow();
        test.decrease(amount);
    }

    public void minus2(final long amount) {
        final var test = pessimisticTestRepository.findById(1L).orElseThrow();
        test.decrease(amount);
    }
}
