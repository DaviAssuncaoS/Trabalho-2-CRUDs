package br.com.portoseguro.products.mapper;

import br.com.portoseguro.products.dto.CreateUpdateSupplierDTO;
import br.com.portoseguro.products.dto.SupplierDTO;
import br.com.portoseguro.products.entity.Supplier;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper
public interface SupplierMapper {

    SupplierDTO toDto(Supplier supplier);
    Supplier toEntity(CreateUpdateSupplierDTO createUpdateSupplierDTO);

    List<SupplierDTO> toDtoList(List<Supplier> supplier);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateSupplierFromDto(CreateUpdateSupplierDTO createUpdateSupplierDTO, @MappingTarget Supplier supplier);
}