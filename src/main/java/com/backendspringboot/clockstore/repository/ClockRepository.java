package com.backendspringboot.clockstore.repository;

import com.backendspringboot.clockstore.model.Clock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClockRepository extends JpaRepository<Clock,Integer> {
}
