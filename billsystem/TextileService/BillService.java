package com.bill.billsystem.TextileService;

import com.bill.billsystem.TextileDAO.Bill;
import com.bill.billsystem.TextileRepo.BillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {

    @Autowired
    private BillRepo repoobj;

    // CREATE
    public Bill saveBill(Bill b) {
      return repoobj.save(b);
    }

    // CREATE (Auto total calculation)
    //public Bill saveBill(Bill b) {

        //long total = 0;

        // Calculate total from products
       //  if (b.getProducts() != null) {
       // for (Product p : b.getAllproducts()) {
    //  total += p.getprice();
        //}
    //}

       // b.setTotal_amount(total);
        //b.setNum_of_prod((long) b.getAllProducts().size());

        //return repoobj.save(b);
//}


// READ ALL
    public List<Bill> getAllBills() {
        return repoobj.findAll();
    }

    // READ BY ID
   // public Bill getBillById(Long bill_id) {
        //return repoobj.findById(id).orElse(null);
   // }

    // UPDATE
    public Bill updateBill(Long bill_id, Bill newData) {
        Bill existing = repoobj.findById(bill_id).orElse(null);

        if (existing != null) {
            existing.setTotal_amount(newData.getTotal_amount());
            existing.setNum_of_prod(newData.getNum_of_prod());
            return repoobj.save(existing);
        }
        return null;
    }

    // DELETE
    public String deleteBill(Long bill_id) {
        repoobj.deleteById(bill_id);
        return "Bill deleted successfully";
    }
}