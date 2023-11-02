package guru.springframework.msscbrewery.web.controller;

import guru.springframework.msscbrewery.service.CustomerService;
import guru.springframework.msscbrewery.web.model.CustomerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("{id}")
    public ResponseEntity<CustomerDto> read(@PathVariable UUID id) {
        return new ResponseEntity<>(customerService.read(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpHeaders> create(@RequestBody CustomerDto customer) {
        CustomerDto newCustomer = customerService.create(customer);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.LOCATION, "/api/v1/customer/" + newCustomer.getId());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable UUID id, @RequestBody CustomerDto customer) {
        customerService.update(id, customer);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        customerService.delete(id);
    }
}
