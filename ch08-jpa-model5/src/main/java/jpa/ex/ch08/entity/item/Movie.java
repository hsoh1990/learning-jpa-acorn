package jpa.ex.ch08.entity.item;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("M")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Movie extends Item {
    private String director;
    private String actor;
}
