package com.backendspringboot.clockstore.model;


import lombok.*;

import javax.persistence.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Clock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String model;
    private Double price;
    private Integer stock;


}
