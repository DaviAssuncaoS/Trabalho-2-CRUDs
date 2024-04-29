package br.com.portoseguro.products.resource;

import br.com.portoseguro.products.dto.CreateUpdateSupplierDTO;
import br.com.portoseguro.products.dto.SupplierDTO;
import br.com.portoseguro.products.entity.Supplier;
import br.com.portoseguro.products.resource.standard.ResponseDTO;
import br.com.portoseguro.products.resource.standard.ResponseType;
import br.com.portoseguro.products.resource.standard.StandardResponse;
import br.com.portoseguro.products.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/suppliers", consumes = "application/json", produces = "application/json")
public class SupplierResource {

    @Autowired
    private SupplierService supplierService;
    @Autowired
    private MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<ResponseDTO> findAllSupplier(Pageable pageable) {

        Page<Supplier> pageSupplierDTO = supplierService.findAll(pageable);

        return StandardResponse.generateResponse(
                null,
                null,
                ResponseType.SUCCESS,
                HttpStatus.OK,
                pageSupplierDTO);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ResponseDTO> findSupplierById(@PathVariable(value = "id") Long id) {

        SupplierDTO supplierDTO = supplierService.findSupplierById(id);
        return StandardResponse.generateResponse(
                null,
                null,
                ResponseType.SUCCESS,
                HttpStatus.OK,
                supplierDTO);

    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ResponseDTO> createSupplier(@RequestBody CreateUpdateSupplierDTO createUpdateSupplierDTO) {

        SupplierDTO supplierDTO = supplierService.createSupplier(createUpdateSupplierDTO);
        return StandardResponse.generateResponse(
                messageSource.getMessage("supplier.create.success.message",null,null),
                null,
                ResponseType.SUCCESS,
                HttpStatus.OK,
                supplierDTO);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<ResponseDTO> updateSupplier(@PathVariable(value = "id") Long id,
                                                     @RequestBody CreateUpdateSupplierDTO createUpdateSupplierDTO) {

        SupplierDTO supplierDTO = supplierService.updateSupplier(id, createUpdateSupplierDTO);
        return StandardResponse.generateResponse(
                messageSource.getMessage("supplier.update.success.message",null,null),
                null,
                ResponseType.SUCCESS,
                HttpStatus.OK,
                supplierDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ResponseDTO> inactivateSupplier(@PathVariable(value = "id") Long id) {

        supplierService.deleteSupplier(id);
        return StandardResponse.generateResponse(
                messageSource.getMessage("supplier.inactivate.success.message",null,null),
                null,
                ResponseType.SUCCESS,
                HttpStatus.OK,
                null);
    }
}
