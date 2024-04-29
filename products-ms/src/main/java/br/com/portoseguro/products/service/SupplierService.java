package br.com.portoseguro.products.service;

import br.com.portoseguro.products.dto.CreateUpdateSupplierDTO;
import br.com.portoseguro.products.dto.SupplierDTO;
import br.com.portoseguro.products.entity.Supplier;
import br.com.portoseguro.products.enums.Status;
import br.com.portoseguro.products.exception.custom.BusinessException;
import br.com.portoseguro.products.exception.custom.RecordNotFoundException;
import br.com.portoseguro.products.mapper.SupplierMapper;
import br.com.portoseguro.products.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;
    @Autowired
    private SupplierMapper supplierMapper;
    @Autowired
    private MessageSource messageSource;

    public Page<Supplier> findAll(Pageable pageable) {

        Page<Supplier> pageSupplier = supplierRepository.findAll(pageable);

        if (pageSupplier == null || pageSupplier.isEmpty())
            throw new RecordNotFoundException();

        return pageSupplier;
    }

    public Page<Supplier> findAll(Specification<Supplier> supplierSpec, Pageable pageable) {

        Page<Supplier> pageSupplier = supplierRepository.findAll(supplierSpec, pageable);

        if (pageSupplier == null || pageSupplier.isEmpty())
            throw new RecordNotFoundException();

        return pageSupplier;
    }

    public SupplierDTO findSupplierById(Long id) {

        Optional<Supplier> supplier = supplierRepository.findById(id);

        if (!supplier.isPresent())
            throw new RecordNotFoundException();

        return supplierMapper.toDto(supplier.get());
    }

    public SupplierDTO createSupplier(CreateUpdateSupplierDTO createUpdateSupplierDTO) {

        Supplier supplier = supplierMapper.toEntity(createUpdateSupplierDTO);
        supplier.setStatus(Status.ATIVO);

        return supplierMapper.toDto(
                supplierRepository.save(supplier));

    }

    public SupplierDTO updateSupplier(Long id, CreateUpdateSupplierDTO createUpdateSupplierDTO) {

        Optional<Supplier> oldSupplier = supplierRepository.findById(id);

        if (!oldSupplier.isPresent())
            throw new RecordNotFoundException();

        Supplier supplier = oldSupplier.get();

        if(supplier.getStatus()!= null && supplier.getStatus().equals(Status.DESATIVADO))
            throw new BusinessException(
                    messageSource.getMessage("supplier.updateinative.exception.code",null,null),
                    messageSource.getMessage("supplier.updateinative.exception.message",null,null));

        supplierMapper.updateSupplierFromDto(createUpdateSupplierDTO, supplier);

        return supplierMapper.toDto(supplierRepository.save(supplier));
    }

    public void deleteSupplier(Long id) {

        Optional<Supplier> oldSupplier = supplierRepository.findById(id);

        if (!oldSupplier.isPresent())
            throw new RecordNotFoundException();

        Supplier supplier = oldSupplier.get();

        supplierRepository.delete(supplier);
    }
}
