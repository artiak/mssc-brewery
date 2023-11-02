package guru.springframework.msscbrewery.service;

import guru.springframework.msscbrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {

    CustomerDto read(UUID id);

    CustomerDto create(CustomerDto customer);

    void update(UUID id, CustomerDto customer);

    void delete(UUID id);
}
