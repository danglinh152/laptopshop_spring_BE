package com.twohdcd.Laptopshop.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "delivery_method")
    private String deliveryMethod;

    @Column(name = "delivery_cost")
    private long deliveryCost;

    @Column(name = "estimated_time")
    private long estimatedTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss a", timezone = "GMT+7")
    @Column(name = "created_at")
    private Instant createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss a", timezone = "GMT+7")
    @Column(name = "updated_at")
    private Instant updatedAt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_by")
    private String updatedBy;
}
