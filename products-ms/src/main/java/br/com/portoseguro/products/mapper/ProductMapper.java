package br.com.portoseguro.products.mapper;

import br.com.portoseguro.products.dto.CreateUpdateProductDTO;
import br.com.portoseguro.products.dto.ProductDTO;
import br.com.portoseguro.products.entity.Product;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper
public interface ProductMapper {

    ProductDTO toDto(Product product);
    Product toEntity(CreateUpdateProductDTO createUpdateProductDTO);

    List<ProductDTO> toDtoList(List<Product> products);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateProductFromDto(CreateUpdateProductDTO createUpdateProductDTO, @MappingTarget Product product);
}