package br.com.portoseguro.products.dto;

import br.com.portoseguro.products.enums.ProductType;
import br.com.portoseguro.products.enums.Status;
import br.com.portoseguro.products.enums.UnitMeasurement;
import lombok.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class SupplierDTO {

    private Long id;
    private String name;
    private String address;
    private String contact;
    private String productSupplied;
    private String barCode;
    private ProductType productType;
    private UnitMeasurement unitMeasurement;
    private Status status;
}