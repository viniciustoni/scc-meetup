package com.vagai.salesorder.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(schema = "sales_order", name = "purchase_order_item")
@SequenceGenerator(name = "sales_order.purchase_order_item_seq", sequenceName = "sales_order.purchase_order_item_seq", allocationSize = 1)
public class PurchaseOrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sales_order.purchase_order_item_seq")
    @Column(name = "id", nullable = false)
    private Long purchaseOrderItemId;

    @ManyToOne
    @JoinColumn(name = "purchase_order_id", referencedColumnName = "id")
    private PurchaseOrder purchaseOrder;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "quantity", nullable = false)
    private BigDecimal quantity;

    @Column(name = "price_item", nullable = false)
    private BigDecimal priceItem;

    @Column(name = "total_price", nullable = false)
    private BigDecimal totalPrice;

}
