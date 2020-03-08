package jpa.ex.ch09.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "DELIVERY")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Delivery {
    @Id
    @GeneratedValue
    @Column(name = "DELIVERY_ID")
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;
}
