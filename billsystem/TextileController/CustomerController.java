package com.bill.billsystem.TextileController;

import com.bill.billsystem.TextileDAO.Customer;
import com.bill.billsystem.TextileService.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService serviceobj;

    // POST → Create customer
    @PostMapping
    public Customer addCustomer(@RequestBody Customer c) {
        return serviceobj.saveCustomer(c);
    }

    // GET → Get all customers
    @GetMapping
    public List<Customer> getAllCustomers() {
        return serviceobj.getAllCustomers();
    }

    // GET → Get customer by ID
    //@GetMapping("/{Cust_id}")
    //public Customer getCustomer(@PathVariable Long Cust_id) {
       // return serviceobj.getCustomerById(Cust_id);
   //}

    // PUT → Update customer
    @PutMapping("/{Cust_id}")
    public Customer updateCustomer(@PathVariable Long Cust_id,
                                   @RequestBody Customer c) {
        return serviceobj.updateCustomer(Cust_id, c);
    }

    // DELETE → Delete customer
    @DeleteMapping("/{Cust_id}")
    public String deleteCustomer(@PathVariable Long Cust_id) {
        return serviceobj.deleteCustomer(Cust_id);
    }
}
