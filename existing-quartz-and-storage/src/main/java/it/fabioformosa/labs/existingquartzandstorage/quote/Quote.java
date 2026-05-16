package it.fabioformosa.labs.existingquartzandstorage.quote;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "QUOTES")
@Data
public class Quote {
    @Id
    private Long id;

    private String author;
    private String text;
}
