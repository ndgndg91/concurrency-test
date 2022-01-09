package com.ndgndg91.test;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @PostMapping("/apis/mall/test/{amount}")
    public ResponseEntity<ApiResult<Void>> test(
            @PathVariable final long amount
    ) {
        try {
            testService.minus(amount);
        } catch (ObjectOptimisticLockingFailureException e) {
            log.error("동시성 감지", e);
            return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.ok().build();
    }

    @PostMapping("/apis/mall/test/p/{amount}")
    public ResponseEntity<ApiResult<Void>> test2(
            @PathVariable final long amount
    ) {
        testService.minus2(amount);
        return ResponseEntity.ok().build();
    }
}
