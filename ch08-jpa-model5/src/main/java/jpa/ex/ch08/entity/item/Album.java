package jpa.ex.ch08.entity.item;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Album extends Item {
    private String artist;
    private String etc;
}
