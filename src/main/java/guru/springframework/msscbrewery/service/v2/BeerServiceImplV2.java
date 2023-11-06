package guru.springframework.msscbrewery.service.v2;

import guru.springframework.msscbrewery.web.model.v2.BeerDtoV2;
import guru.springframework.msscbrewery.web.model.v2.BeerStyleEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class BeerServiceImplV2 implements BeerServiceV2 {
    @Override
    public BeerDtoV2 getBeerById(UUID id) {
        return BeerDtoV2.builder().id(UUID.randomUUID())
            .beerName("Galaxy Cat")
            .beerStyle(BeerStyleEnum.ALE).build();
    }

    @Override
    public BeerDtoV2 saveNewBeer(BeerDtoV2 beer) {
        return BeerDtoV2.builder()
            .id(UUID.randomUUID())
            .build();
    }

    @Override
    public void updateBeer(UUID id, BeerDtoV2 beer) {
        // TODO: 01.11.2023 Provide an impl
    }

    @Override
    public void delete(UUID id) {
        log.info("Deleting beer with id '{}'", id);
        // TODO: 02.11.2023 Provide an impl
    }
}

