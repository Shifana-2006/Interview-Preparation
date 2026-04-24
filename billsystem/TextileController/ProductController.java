package com.bill.billsystem.TextileController;

import com.bill.billsystem.TextileDAO.Product;
import com.bill.billsystem.TextileService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService serviceobj;

    // POST
    @PostMapping
    public Product addProduct(@RequestBody Product p) {
        return serviceobj.saveProduct(p);
    }

    // GET ALL
    @GetMapping
    public List<Product> getAllProducts() {
        return serviceobj.getAllProducts();
    }

    // GET BY ID
    //@GetMapping("/{Prod_id}")
    //public Product getProduct(@PathVariable Long Prod_id) {
     //   return service.getProductById(id);
    //}

    // UPDATE
    @PutMapping("/{prod_id}")
    public Product updateProduct(@PathVariable Long prod_id,
                                 @RequestBody Product p) {
        return serviceobj.updateProduct(prod_id, p);
    }

    // DELETE
    @DeleteMapping("/{prod_id}")
    public String deleteProduct(@PathVariable Long prod_id) {
        return serviceobj.deleteProduct(prod_id);
    }
}