package jpa.ex.ch09.entity;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Address {
    private String city;
    private String street;
    private String zipcode;
}
