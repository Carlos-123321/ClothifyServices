package com.example.apigateway.presentationlayer.customer;



import com.example.apigateway.presentationlayer.customer.CustomerResponseModel;
import com.example.apigateway.presentationlayer.customer.CustomerRequestModel;

import com.example.apigateway.businesslayer.customer.CustomerService;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;


@Slf4j
@RestController
@RequestMapping("api/v1/Customers")
public class CustomerController {

    private final CustomerService CustomerService;

    public CustomerController(CustomerService CustomerService) {
        this.CustomerService = CustomerService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<CustomerResponseModel>> getCustomers() {
        return ResponseEntity.status(HttpStatus.FOUND).body(CustomerService.getCustomers());
    }

    @GetMapping(value = "/{CustomerId}", produces = "application/json")
    public ResponseEntity<CustomerResponseModel> getCustomerByCustomerId(@PathVariable String CustomerId) {
        return ResponseEntity.status(HttpStatus.FOUND).body(CustomerService.getCustomerByCustomerId(CustomerId));
    }

   /* @GetMapping("/filter/{country}")
    public ResponseEntity<List<CustomerResponseModel>> getCustomersByCountryByPhone(@PathVariable String country,
                                                                                    @RequestParam(required = false) Map<String, String> queryParams){

        List<CustomerResponseModel> Customers = CustomerService
                .getCustomersByCountryByPhone(country, queryParams);
        String str;
        str = "The path paramater passed is: country= " + country;

        Set<String> keys = queryParams.keySet();

        for(String k: keys){
            str += "\n param key: " + k;
            str += "\n param value: " + queryParams.get(k);
        }

        return ResponseEntity.ok().body(Customers);
    }
*/

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<CustomerResponseModel> addCustomer(@RequestBody CustomerRequestModel CustomerRequestModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(CustomerService.addCustomer(CustomerRequestModel));
    }


    @PutMapping(value = "/{CustomerId}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<CustomerResponseModel> updateCostumer(@RequestBody CustomerRequestModel CustomerRequestModel, @PathVariable String CustomerId) {
        return ResponseEntity.status(HttpStatus.OK).body(CustomerService.updateCustomer(CustomerRequestModel, CustomerId));
    }

/*
    @DeleteMapping("/{emailAddress}")
    public ResponseEntity<Void> deleteCustomerByEmail(@PathVariable("emailAddress") String email) {
        CustomerService.removeCustomerByEmail(email);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }*/

    @DeleteMapping("/{CustomerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable String CustomerId){
        CustomerService.removeCustomer(CustomerId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }


}
