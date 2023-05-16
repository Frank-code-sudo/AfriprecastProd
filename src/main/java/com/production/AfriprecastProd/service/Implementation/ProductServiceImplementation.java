package com.production.AfriprecastProd.service.Implementation;

import com.production.AfriprecastProd.model.Product;
import com.production.AfriprecastProd.repository.ProductRepository;
import com.production.AfriprecastProd.service.ProductInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImplementation implements ProductInterface {

    @Autowired
    ProductRepository ProductRepository;

    @Override
    public Product registerProduct(Product prod) {
        return ProductRepository.save(prod);
    }

    @Override
    public Product updateProduct(Product prod) {
        Product product = findProductById(prod);
        if (product != null) {
            product.setId(prod.getId());
            product.setSerial_number(prod.getSerial_number());
            product.setName(prod.getName());
            return ProductRepository.save(product);
        } else {
            return registerProduct(prod);
        }
    }

    @Override
    public void deleteProductById(Product prod) {
        ProductRepository.delete(prod);
    }
    @Override
    public List<Product> Productlist() {

        return ProductRepository.findAll();
    }

    @Override
    public Product findProductById(Product prod) {
        return ProductRepository.findById(prod.getId()).get();
    }


}

