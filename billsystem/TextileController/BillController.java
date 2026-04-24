package com.bill.billsystem.TextileController;

import com.bill.billsystem.TextileDAO.Bill;
import com.bill.billsystem.TextileService.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bill")
public class BillController {

    @Autowired
    private BillService serviceobj;

    // POST
    @PostMapping
    public Bill addBill(@RequestBody Bill b) {
        return serviceobj.saveBill(b);
    }

    // GET ALL
    @GetMapping
    public List<Bill> getAllBills() {
        return serviceobj.getAllBills();
    }

    // GET BY ID
   // @GetMapping("/{id}")
   // public Bill getBill(@PathVariable Long bill_id) {
       // return serviceobj.getBillById(bill_id);
   // }

    // UPDATE
    @PutMapping("/{id}")
    public Bill updateBill(@PathVariable Long bill_id,
                           @RequestBody Bill b) {
        return serviceobj.updateBill(bill_id, b);
    }

    // DELETE
    @DeleteMapping("/{bill_id}")
    public String deleteBill(@PathVariable Long bill_id) {
        return serviceobj.deleteBill(bill_id);
    }
}