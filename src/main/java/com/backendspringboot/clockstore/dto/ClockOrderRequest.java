package com.backendspringboot.clockstore.dto;

import lombok.Data;

import java.util.List;

@Data
public class ClockOrderRequest {
    private List<Integer> clockIdList;
    private String userName;

}
