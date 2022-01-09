CREATE TABLE optimistic_test
(
    id      bigint AUTO_INCREMENT PRIMARY KEY,
    version bigint NOT NULL DEFAULT 0,
    counter bigint NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
INSERT INTO optimistic_test(version, counter) VALUE (0, 5000);
CREATE TABLE pessimistic_test
(
    id      bigint AUTO_INCREMENT PRIMARY KEY,
    counter bigint NOT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

INSERT INTO pessimistic_test(counter) VALUE (5000);