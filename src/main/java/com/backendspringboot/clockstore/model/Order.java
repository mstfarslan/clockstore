package com.backendspringboot.clockstore.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
@Data
@Getter
@Setter
@Table
@Builder
@Entity(name = "clockOrder")
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;

    private String userName;

    @Column
    @ElementCollection(targetClass = Integer.class)
    private List<Integer> clockList;
    private Double totalPrice;
}
