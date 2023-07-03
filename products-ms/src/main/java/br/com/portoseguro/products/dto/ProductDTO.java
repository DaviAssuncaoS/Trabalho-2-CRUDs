package br.com.portoseguro.products.dto;

import br.com.portoseguro.products.enums.ProductType;
import br.com.portoseguro.products.enums.Status;
import br.com.portoseguro.products.enums.UnitMeasurement;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ProductDTO {

    private Long id;
    private String name;
    private String description;
    private String barCode;
    private ProductType productType;
    private UnitMeasurement unitMeasurement;
    private Status status;
}
