package com.example.shop.entity;

import com.example.shop.enums.StatusOrder;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "total_price")
    Long total;

    @Column(name = "quantity_product")
    Long quantity;

    @Column(name = "date")
    Date date;

    @Column(name = "status")
    String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @OneToMany(mappedBy = "order")
    List<Item> items;
}
