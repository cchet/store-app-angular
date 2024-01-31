package at.ihet.store.electronic.service.catalog.product.inbound.rest;

import at.ihet.store.electronic.service.catalog.product.application.query.ProductQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path = "/product")
public class ProductApi {

    private final ProductQuery productQuery;
    private final ProductViewMapper productViewMapper;

    @Autowired
    public ProductApi(ProductQuery productQuery, ProductViewMapper productViewMapper) {
        this.productQuery = productQuery;
        this.productViewMapper = productViewMapper;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<ProductView> list() {
        var products = productQuery.listAll();
        return productViewMapper.toProductViews(products);
    }

    @GetMapping(path = "{id}")
    ProductView byId(@PathVariable("id") String id) {
        var product = productQuery.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No product found for id: " + id));
        return productViewMapper.toProductView(product);
    }
}
