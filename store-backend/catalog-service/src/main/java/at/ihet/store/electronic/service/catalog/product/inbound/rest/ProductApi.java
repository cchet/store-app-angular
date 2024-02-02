package at.ihet.store.electronic.service.catalog.product.inbound.rest;

import at.ihet.store.electronic.service.catalog.product.application.query.ProductQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/product",produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductApi {

    private final ProductQuery productQuery;
    private final ProductViewMapper productViewMapper;

    @Autowired
    public ProductApi(ProductQuery productQuery, ProductViewMapper productViewMapper) {
        this.productQuery = productQuery;
        this.productViewMapper = productViewMapper;
    }

    @GetMapping()
    List<ProductView> list(@RequestParam(value = "id", required = false) List<String> ids) {
        var products = (ids == null) ? productQuery.listAll() : productQuery.findByIds(ids);
        return productViewMapper.toProductViews(products);
    }

    @GetMapping(path = "{id}")
    ProductView byId(@PathVariable("id") String id) {
        var product = productQuery.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No product found for id: " + id));
        return productViewMapper.toProductView(product);
    }
}
