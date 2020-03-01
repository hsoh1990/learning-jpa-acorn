package jpa.ex.ch07.entity;


import jpa.ex.ch07.entity.item.Item;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "ORDER_ITEM")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class OrderItem {
    @Id
    @GeneratedValue
    @Column(name = "ORDER_ITEM_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    private int orderPrice; //주문 가격
    private int count;      //주문 수량
}
