package guru.springframework.msscbrewery.service.v2;

import guru.springframework.msscbrewery.web.model.v2.BeerDtoV2;

import java.util.UUID;

public interface BeerServiceV2 {
    BeerDtoV2 getBeerById(UUID id);

    BeerDtoV2 saveNewBeer(BeerDtoV2 BeerDtoV2);

    void updateBeer(UUID id, BeerDtoV2 beer);

    void delete(UUID id);
}
