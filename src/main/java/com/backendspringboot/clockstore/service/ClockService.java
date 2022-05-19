package com.backendspringboot.clockstore.service;

import com.backendspringboot.clockstore.model.Clock;
import com.backendspringboot.clockstore.repository.ClockRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClockService {
    private final ClockRepository clockRepository;

    public ClockService(ClockRepository clockRepository) {

        this.clockRepository = clockRepository;
    }

    public Optional<Clock> findByClockId(Integer clockId){
        return clockRepository.findById(clockId);
    }

    public List<Clock> getAllClocks(){
        return clockRepository.findAll();
    }

}
