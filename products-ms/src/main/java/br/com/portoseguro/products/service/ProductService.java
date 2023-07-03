package br.com.portoseguro.products.service;

import br.com.portoseguro.products.dto.CreateUpdateProductDTO;
import br.com.portoseguro.products.dto.ProductDTO;
import br.com.portoseguro.products.entity.Product;
import br.com.portoseguro.products.enums.Status;
import br.com.portoseguro.products.exception.custom.BusinessException;
import br.com.portoseguro.products.exception.custom.RecordNotFoundException;
import br.com.portoseguro.products.mapper.ProductMapper;
import br.com.portoseguro.products.repository.ProductRepository;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private MessageSource messageSource;

    public Page<Product> findAll(Pageable pageable) {

        Page<Product> pageProduct = productRepository.findAll(pageable);

        if (pageProduct == null || pageProduct.isEmpty())
            throw new RecordNotFoundException();

        return pageProduct;
    }

    public Page<Product> findAll(Specification<Product> productSpec, Pageable pageable) {

        Page<Product> pageProduct = productRepository.findAll(productSpec, pageable);

        if (pageProduct == null || pageProduct.isEmpty())
            throw new RecordNotFoundException();

        return pageProduct;
    }

    public ProductDTO findProductById(Long id) {

        Optional<Product> product = productRepository.findById(id);

        if (!product.isPresent())
            throw new RecordNotFoundException();

        return productMapper.toDto(product.get());
    }

    public ProductDTO createProduct(CreateUpdateProductDTO createUpdateProductDTO) {

        Product product = productMapper.toEntity(createUpdateProductDTO);
        product.setStatus(Status.ATIVO);

        return productMapper.toDto(
                productRepository.save(product));

    }

    public ProductDTO updateProduct(Long id, CreateUpdateProductDTO createUpdateProductDTO) {

        Optional<Product> oldProduct = productRepository.findById(id);

        if (!oldProduct.isPresent())
            throw new RecordNotFoundException();

        Product product = oldProduct.get();

        if(product.getStatus()!= null && product.getStatus().equals(Status.DESATIVADO))
            throw new BusinessException(
                    messageSource.getMessage("product.updateinative.exception.code",null,null),
                    messageSource.getMessage("product.updateinative.exception.message",null,null));

        productMapper.updateProductFromDto(createUpdateProductDTO, product);

        return productMapper.toDto(productRepository.save(product));
    }

    public void inactivateProduct(Long id) {

        Optional<Product> activeProduct = productRepository.findById(id);

        if (!activeProduct.isPresent())
            throw new RecordNotFoundException();

        Product product = activeProduct.get();
        product.setStatus(Status.DESATIVADO);
        productRepository.save(product);
    }
}
