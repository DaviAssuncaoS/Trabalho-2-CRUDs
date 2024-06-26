package br.com.portoseguro.products.resource;

import br.com.portoseguro.products.dto.CreateUpdateProductDTO;
import br.com.portoseguro.products.dto.ProductDTO;
import br.com.portoseguro.products.entity.Product;
import br.com.portoseguro.products.resource.standard.ResponseDTO;
import br.com.portoseguro.products.resource.standard.ResponseType;
import br.com.portoseguro.products.resource.standard.StandardResponse;
import br.com.portoseguro.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/products", consumes = "application/json", produces = "application/json")
public class ProductResource {

    @Autowired
    private ProductService productService;
    @Autowired
    private MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<ResponseDTO> findAllProduct(Pageable pageable) {

        Page<Product> pageProductDTO = productService.findAll(pageable);

        return StandardResponse.generateResponse(
                null,
                null,
                ResponseType.SUCCESS,
                HttpStatus.OK,
                pageProductDTO);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ResponseDTO> findProductById(@PathVariable(value = "id") Long id) {

        ProductDTO productDTO = productService.findProductById(id);
        return StandardResponse.generateResponse(
                null,
                null,
                ResponseType.SUCCESS,
                HttpStatus.OK,
                productDTO);

    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ResponseDTO> createProduct(@RequestBody CreateUpdateProductDTO createUpdateProductDTO) {

        ProductDTO productDTO = productService.createProduct(createUpdateProductDTO);
        return StandardResponse.generateResponse(
                messageSource.getMessage("product.create.success.message", null, null),
                null,
                ResponseType.SUCCESS,
                HttpStatus.OK,
                productDTO);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<ResponseDTO> updateProduct(@PathVariable(value = "id") Long id,
                                                     @RequestBody CreateUpdateProductDTO createUpdateProductDTO) {

        ProductDTO productDTO = productService.updateProduct(id, createUpdateProductDTO);
        return StandardResponse.generateResponse(
                messageSource.getMessage("product.update.success.message", null, null),
                null,
                ResponseType.SUCCESS,
                HttpStatus.OK,
                productDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ResponseDTO> inactivateProduct(@PathVariable(value = "id") Long id) {

        productService.deleteProduct(id);
        return StandardResponse.generateResponse(
                messageSource.getMessage("product.inactivate.success.message", null, null),
                null,
                ResponseType.SUCCESS,
                HttpStatus.OK,
                null);
    }
}
