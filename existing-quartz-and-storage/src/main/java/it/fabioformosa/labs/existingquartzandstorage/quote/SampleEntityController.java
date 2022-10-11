package it.fabioformosa.labs.existingquartzandstorage.quote;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/quotes")
@RestController
public class SampleEntityController {
    private QuoteService quoteService;

    public SampleEntityController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping
    public List<QuoteDTO> getAll(){
        return quoteService.getAll();
    }

}
