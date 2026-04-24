package com.bill.billsystem.TextileService;

import com.bill.billsystem.TextileDAO.Product;
import com.bill.billsystem.TextileRepo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repoobj;

    // CREATE
    public Product saveProduct(Product p) {
        return repoobj.save(p);
    }

    // READ ALL
    public List<Product> getAllProducts() {
        return repoobj.findAll();
    }

    // READ BY ID
    //public Product getProductById(Long Prod_id) {
        //return repoobj.findById(id).orElse(null);
   // }

    // UPDATE
    public Product updateProduct(Long prod_id, Product newData) {
        Product existing = repoobj.findById(prod_id).orElse(null);

        if (existing != null) {
            existing.setProd_name(newData.getProd_name());
            existing.setPrice(newData.getPrice());
            return repoobj.save(existing);
        }
        return null;
    }

    // DELETE
    public String deleteProduct(Long prod_id) {
        repoobj.deleteById(prod_id);
        return "Product deleted successfully";
    }
}
