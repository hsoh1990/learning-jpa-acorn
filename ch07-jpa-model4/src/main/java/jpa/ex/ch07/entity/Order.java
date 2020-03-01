package jpa.ex.ch07.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ORDERS")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Order extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<OrderItem>();

    @OneToOne
    @JoinColumn(name = "DELIVERY_ID")
    private Delivery delivery;

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate; //주문시간

    @Enumerated(EnumType.STRING)
    private OrderStatus status; //주문상태

    public void setMember(Member member) {
        // 기존 관계 제거
        if (this.member != null) {
            this.member.getOrders().remove(this);
        }

        // set member
        this.member = member;

        // member 객체의 order 추가..
        member.getOrders().add(this);
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
        delivery.setOrder(this);
    }
}
