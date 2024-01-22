package com.example.demo.rest;

import com.example.demo.dto.CustomerDto;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/customer")
public class CustomerController {

    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping(path = "/{name}")
    public ResponseEntity<CustomerDto> getCustomerByName(@PathVariable String name) {
        Customer customer = customerRepository.findCustomerByName(name).orElseThrow(EntityNotFoundException::new);
        CustomerDto customerDto = new CustomerDto(customer.getId(), customer.getName(), customer.getDateOfBirth());

        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDto> createInstructor(@RequestBody CustomerDto customerDto) {
        Customer customer = new Customer(customerDto.getName(), customerDto.getDateOfBirth());
        Customer savedCustomer = customerRepository.save(customer);

        CustomerDto dto = new CustomerDto(savedCustomer.getId(), savedCustomer.getName(), savedCustomer.getDateOfBirth());
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{fromName}/{toName}")
    public ResponseEntity<String> updateCustomerName(@PathVariable String fromName, @PathVariable String toName) {
        return new ResponseEntity<>("Name changed from ".concat(fromName).concat(" to ").concat(toName), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{name}")
    public ResponseEntity<String> deleteCustomer(@PathVariable String name) {
        return new ResponseEntity<>("Deleted ".concat(name), HttpStatus.OK);
    }
}
