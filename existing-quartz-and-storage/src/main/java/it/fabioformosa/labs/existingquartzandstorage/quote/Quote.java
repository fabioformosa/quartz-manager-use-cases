package it.fabioformosa.labs.existingquartzandstorage.quote;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "QUOTES")
@Data
public class Quote {
    @Id
    private Long id;

    private String author;
    private String text;
}
