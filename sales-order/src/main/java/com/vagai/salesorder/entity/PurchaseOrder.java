package com.vagai.salesorder.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

@Data
@Entity
@Table(schema = "sales_order", name = "purchase_order")
@SequenceGenerator(name = "sales_order.purchase_order_seq", sequenceName = "sales_order.purchase_order_seq", allocationSize = 1)
public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sales_order.purchase_order_seq")
    @Column(name = "id", nullable = false)
    private Long purchaseOrderId;

    @Column(name = "client_id", nullable = false)
    private Long clientId;

    @Column(name = "total_amount", nullable = false)
    private BigDecimal totalAmount;

    @Column(name = "discount", nullable = false)
    private BigDecimal discount;

    @OneToMany(fetch = LAZY, mappedBy = "purchaseOrder", cascade = ALL, orphanRemoval = true)
    private List<PurchaseOrderItem> purchaseOrderItems;

}
