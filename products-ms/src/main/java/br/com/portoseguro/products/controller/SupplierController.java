package br.com.portoseguro.products.controller;

import br.com.portoseguro.products.dto.CreateUpdateSupplierDTO;
import br.com.portoseguro.products.dto.SupplierDTO;
import br.com.portoseguro.products.entity.Supplier;
import br.com.portoseguro.products.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    private final SupplierService supplierService;

    @Autowired
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping
    public ResponseEntity<Page<Supplier>> getAllSuppliers(Pageable pageable) {
        Page<Supplier> suppliers = supplierService.findAll(pageable);
        return new ResponseEntity<>(suppliers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierDTO> getSupplierById(@PathVariable Long id) {
        SupplierDTO supplier = supplierService.findSupplierById(id);
        return new ResponseEntity<>(supplier, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SupplierDTO> createSupplier(@RequestBody CreateUpdateSupplierDTO createUpdateSupplierDTO) {
        SupplierDTO supplier = supplierService.createSupplier(createUpdateSupplierDTO);
        return new ResponseEntity<>(supplier, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupplierDTO> updateSupplier(@PathVariable Long id, @RequestBody CreateUpdateSupplierDTO createUpdateSupplierDTO) {
        SupplierDTO updatedSupplier = supplierService.updateSupplier(id, createUpdateSupplierDTO);
        return new ResponseEntity<>(updatedSupplier, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable Long id) {
        supplierService.deleteSupplier(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
