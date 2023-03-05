package com.example.weather.repository;

import com.example.weather.domain.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
                                                    // 어떤클래스, key (data-type)
public interface JpaMemoRepository extends JpaRepository<Memo, Integer> {
}
