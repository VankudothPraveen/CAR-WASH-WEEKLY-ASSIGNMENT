package com.carwash.carwash.service;

import com.carwash.carwash.dto.CustomerCleanerResponse;
import com.carwash.carwash.entity.cleaner;
import com.carwash.carwash.entity.Customer;
import com.carwash.carwash.repository.CleanerRepository;
import com.carwash.carwash.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarWashService {

    private final CleanerRepository cleanerRepository;
    private final CustomerRepository customerRepository;

    public CarWashService(CleanerRepository cleanerRepository,
                          CustomerRepository customerRepository) {
        this.cleanerRepository = cleanerRepository;
        this.customerRepository = customerRepository;
    }

    // ================= CLEANER CRUD =================

    // CREATE
    public cleaner addCleaner(cleaner cleaner) {
        return cleanerRepository.save(cleaner);
    }

    // READ ALL
    public List<cleaner> getAllCleaners() {
        return cleanerRepository.findAll();
    }

    // READ BY ID
    public cleaner getCleanerById(Long id) {
        return cleanerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cleaner not found"));
    }

    // READ BY AREA
    public List<cleaner> getCleanerByArea(String area) {
        List<cleaner> cleaners = cleanerRepository.findByArea(area);
        if (cleaners == null || cleaners.isEmpty()) {
            throw new RuntimeException("Cleaner not found in area: " + area);
        }
        return cleaners;
    }

    // UPDATE
    public cleaner updateCleaner(Long id, cleaner updatedCleaner) {
        cleaner existingCleaner = getCleanerById(id);

        existingCleaner.setName(updatedCleaner.getName());
        existingCleaner.setExperience(updatedCleaner.getExperience());
        existingCleaner.setSalary(updatedCleaner.getSalary());
        existingCleaner.setArea(updatedCleaner.getArea());

        return cleanerRepository.save(existingCleaner);
    }

    // DELETE
    public void deleteCleaner(Long id) {
        cleanerRepository.deleteById(id);
    }

    // ================= CUSTOMER CRUD =================

    // CREATE
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // READ ALL
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // READ BY ID
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    // UPDATE
    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        Customer customer = getCustomerById(id);

        customer.setName(updatedCustomer.getName());
        customer.setArea(updatedCustomer.getArea());
        customer.setPackageType(updatedCustomer.getPackageType());
        customer.setStartDate(updatedCustomer.getStartDate());
        customer.setEndDate(updatedCustomer.getEndDate());

        return customerRepository.save(customer);
    }

    // DELETE
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    // ============ BUSINESS LOGIC =================

    public String checkServiceAvailability(Long customerId) {
        Customer customer = getCustomerById(customerId);

        if (cleanerRepository.findByArea(customer.getArea()).isEmpty()) {
            return "❌ Service NOT available in " + customer.getArea();
        }

        return "✅ Service available in " + customer.getArea();
    }
    public CustomerCleanerResponse assignCleanerToCustomer(Long customerId) {

        Customer customer = getCustomerById(customerId);

        List<cleaner> cleaners =
                cleanerRepository.findByArea(customer.getArea());

        if (cleaners.isEmpty()) {
            throw new RuntimeException(
                    "No cleaner available in area: " + customer.getArea()
            );
        }

        cleaner cleaner = cleaners.get(0);
        customer.setCleaner(cleaner);
        customerRepository.save(customer);

        CustomerCleanerResponse response = new CustomerCleanerResponse();

        response.setCustomerName(customer.getName());
        response.setCustomerArea(customer.getArea());
        response.setCleanerName(cleaner.getName());
        response.setCleanerExperience(cleaner.getExperience());
        response.setPackageDuration(customer.getPackageType());
        response.setServiceType("FULL CLEAN / OUTER CLEAN + WATERING");
        response.setStartDate(customer.getStartDate());
        response.setEndDate(customer.getEndDate());
        response.setMessage(
                "Customer " + customer.getName()
                        + " is mapped with Cleaner " + cleaner.getName()
        );

        return response;
    }



}
