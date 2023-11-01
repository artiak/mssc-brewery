package guru.springframework.msscbrewery.web.controller;

import guru.springframework.msscbrewery.service.BeerService;
import guru.springframework.msscbrewery.web.model.BeerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("#{T(guru.springframework.msscbrewery.web.controller.BeerController).PATH}")
public class BeerController {

    public static final String PATH = "/api/v1/beer";

    private final BeerService beerService;

    BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("{id}")
    public ResponseEntity<BeerDto> get(@PathVariable UUID id) {
        return new ResponseEntity<>(beerService.getBeerById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpHeaders> handle(@RequestBody BeerDto beer) {
        BeerDto savedBeer = beerService.saveNewBeer(beer);

        HttpHeaders headers = new HttpHeaders();
        //todo add hostname to URL
        headers.add("Location", PATH + "/" + savedBeer.getId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<HttpHeaders> update(@PathVariable UUID id, @RequestBody BeerDto beer) {
        beerService.updateBeer(id, beer);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
