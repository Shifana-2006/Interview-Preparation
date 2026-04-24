package com.bill.billsystem.TextileService;

import com.bill.billsystem.TextileDAO.Customer;
import com.bill.billsystem.TextileRepo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo repoobj;

    // CREATE
    public Customer saveCustomer(Customer c) {
        return repoobj.save(c);
    }

    // READ ALL
    public List<Customer> getAllCustomers() {
        return repoobj.findAll();
    }

    // READ BY ID
    //public Customer getCustomerById(Long id) {
       // return repoobj.findById(id).orElse(null);
    //}

    // UPDATE
    public Customer updateCustomer(Long Cust_id, Customer newData) {
        Customer existing = repoobj.findById(Cust_id).orElse(null);

        if (existing != null) {
            existing.setCust_name(newData.getCust_name());
            existing.setPh_no(newData.getPh_no());
            existing.setLocation(newData.getLocation());
            return repoobj.save(existing);
        }
        return null;
    }

    // DELETE
    public String deleteCustomer(Long Cust_id) {
        repoobj.deleteById(Cust_id);
        return "Customer deleted successfully";
    }
}
