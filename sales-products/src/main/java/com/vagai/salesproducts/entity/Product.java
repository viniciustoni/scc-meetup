package com.vagai.salesproducts.entity;

import com.vagai.salesproducts.entity.enumerated.UnitOfMeasure;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Data
@Entity
@Table(schema = "product", name = "product")
@SequenceGenerator(name = "product.product_seq", sequenceName = "product.product_seq", allocationSize = 1)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product.product_seq")
    @Column(name = "id", nullable = false)
    private Long productId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "unit_price", nullable = false)
    private BigDecimal unitPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "unit_of_measure", nullable = false)
    private UnitOfMeasure unitOfMeasure;

    @Column(name = "quantity_total", nullable = false)
    private BigDecimal qtdTotal;

    @Column(name = "quantity_available", nullable = false)
    private BigDecimal qtdAvailable;

    @Column(name = "quantity_reserved", nullable = false)
    private BigDecimal qtdReserved;

    @Column(name = "quantity_sold", nullable = false)
    private BigDecimal qtdSold;

    @Column(name = "created_date", nullable = false, updatable = false)
    private ZonedDateTime createdDate = ZonedDateTime.now();

    @Column(name = "updated_date", nullable = false)
    private ZonedDateTime updatedDate = ZonedDateTime.now();
}
