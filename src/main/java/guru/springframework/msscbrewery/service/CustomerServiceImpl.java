package guru.springframework.msscbrewery.service;

import guru.springframework.msscbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto read(UUID id) {
        return CustomerDto.builder()
            .id(UUID.randomUUID())
            .name("Joe Buck")
            .build();
    }

    @Override
    public CustomerDto create(CustomerDto customer) {
        return CustomerDto.builder()
            .id(UUID.randomUUID())
            .name(customer.getName())
            .build();
    }

    @Override
    public void update(UUID id, CustomerDto customer) {
        // TODO: 02.11.2023 Provide an impl
    }

    @Override
    public void delete(UUID id) {
        // TODO: 02.11.2023 Provide an impl
    }
}
