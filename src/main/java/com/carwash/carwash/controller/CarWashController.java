package com.carwash.carwash.controller;
import com.carwash.carwash.entity.cleaner;
import com.carwash.carwash.entity.Customer;
import com.carwash.carwash.dto.CustomerCleanerResponse;
import com.carwash.carwash.service.CarWashService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarWashController {

    private final CarWashService service;

    public CarWashController(CarWashService service) {
        this.service = service;
    }

    // ================= CLEANER CRUD =================

    @PostMapping("/cleaners")
    public cleaner addCleaner(@RequestBody cleaner cleaner) {
        return service.addCleaner(cleaner);
    }

    @GetMapping("/cleaners")
    public List<cleaner> getAllCleaners() {
        return service.getAllCleaners();
    }

    @GetMapping("/cleaners/{id}")
    public cleaner getCleanerById(@PathVariable Long id) {
        return service.getCleanerById(id);
    }

    @PutMapping("/cleaners/{id}")
    public cleaner updateCleaner(@PathVariable Long id,
                                 @RequestBody cleaner cleaner) {
        return service.updateCleaner(id, cleaner);
    }

    @DeleteMapping("/cleaners/{id}")
    public String deleteCleaner(@PathVariable Long id) {
        service.deleteCleaner(id);
        return "Cleaner deleted successfully";
    }

    // ================= CUSTOMER CRUD =================

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer) {
        return service.addCustomer(customer);
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return service.getAllCustomers();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return service.getCustomerById(id);
    }

    @PutMapping("/customers/{id}")
    public Customer updateCustomer(@PathVariable Long id,
                                   @RequestBody Customer customer) {
        return service.updateCustomer(id, customer);
    }

    @DeleteMapping("/customers/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        service.deleteCustomer(id);
        return "Customer deleted successfully";
    }

    // ============ CHECK SERVICE =================

    @GetMapping("/check/{customerId}")
    public String checkService(@PathVariable Long customerId) {
        return service.checkServiceAvailability(customerId);
    }

    @GetMapping("/cleaner/area/{area}")
    public List<cleaner> getCleanerByArea(@PathVariable String area) {
        return service.getCleanerByArea(area);
    }
    @PutMapping("/customers/{id}/assign-cleaner")
    public CustomerCleanerResponse assignCleaner(@PathVariable Long id) {
        return service.assignCleanerToCustomer(id);
    }


}
