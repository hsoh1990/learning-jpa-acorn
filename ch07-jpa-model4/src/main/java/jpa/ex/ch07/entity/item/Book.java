package jpa.ex.ch07.entity.item;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book extends Item {
    private String author;
    private String isbn;
}
