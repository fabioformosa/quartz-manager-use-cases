package it.fabioformosa.labs.existingquartzandstorage.quote;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuoteDTO {
    private final String author;
    private final String text;
}
