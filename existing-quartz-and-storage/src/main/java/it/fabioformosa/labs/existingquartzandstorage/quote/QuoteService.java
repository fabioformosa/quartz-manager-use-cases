package it.fabioformosa.labs.existingquartzandstorage.quote;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteService {

    private QuoteRepository quoteRepository;

    public QuoteService(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    public List<QuoteDTO> getAll() {
        List<Quote> quotes = quoteRepository.findAll();
        return quotes.stream().map(QuoteService::fromQuoteToQuoteDTO).toList();
    }

    private static QuoteDTO fromQuoteToQuoteDTO(Quote quote) {
        return QuoteDTO.builder()
                .author(quote.getAuthor())
                .text(quote.getText())
                .build();
    }
}
