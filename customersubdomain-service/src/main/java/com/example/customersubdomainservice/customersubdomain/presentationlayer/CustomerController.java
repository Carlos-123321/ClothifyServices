package com.example.customersubdomainservice.customersubdomain.presentationlayer;


import com.example.customersubdomainservice.customersubdomain.businesslayer.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;


@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<CustomerResponseModel>> getCustomers() {
        return ResponseEntity.status(HttpStatus.FOUND).body(customerService.getCustomers());
    }

    @GetMapping(value = "/{customerId}", produces = "application/json")
    public ResponseEntity<CustomerResponseModel> getCustomerByCustomerId(@PathVariable String customerId) {
        return ResponseEntity.status(HttpStatus.FOUND).body(customerService.getCustomerByCustomerId(customerId));
    }

    @GetMapping("/filter/{country}")
    public ResponseEntity<List<CustomerResponseModel>> getCustomersByCountryByPhone(@PathVariable String country,
                                                                                    @RequestParam(required = false) Map<String, String> queryParams){

        List<CustomerResponseModel> customers = customerService
                .getCustomersByCountryByPhone(country, queryParams);
        String str;
        str = "The path paramater passed is: country= " + country;

        Set<String> keys = queryParams.keySet();

        for(String k: keys){
            str += "\n param key: " + k;
            str += "\n param value: " + queryParams.get(k);
        }

        return ResponseEntity.ok().body(customers);
    }


    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<CustomerResponseModel> addCustomer(@RequestBody CustomerRequestModel customerRequestModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.addCustomer(customerRequestModel));
    }


    @PutMapping(value = "/{customerId}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<CustomerResponseModel> updateCostumer(@RequestBody CustomerRequestModel customerRequestModel, @PathVariable String customerId) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.updateCustomer(customerRequestModel, customerId));
    }

/*
    @DeleteMapping("/{emailAddress}")
    public ResponseEntity<Void> deleteCustomerByEmail(@PathVariable("emailAddress") String email) {
        customerService.removeCustomerByEmail(email);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }*/

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable String customerId){
        customerService.deleteCustomer(customerId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }


}
