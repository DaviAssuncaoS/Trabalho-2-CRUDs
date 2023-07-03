package br.com.portoseguro.products.dto;

import br.com.portoseguro.products.enums.ProductType;
import br.com.portoseguro.products.enums.UnitMeasurement;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.EAN;

import java.lang.annotation.Target;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CreateUpdateProductDTO {

    @Schema(description = "{product.name.schema.description}", required = true)
    @NotEmpty(message = "{product.name.notempty}")
    @Size(max = 50, message = "{product.name.size}")
    private String name;

    @Schema(description = "{product.description.schema.description}", required = true)
    @NotEmpty(message = "{product.description.notempty}")
    @Size(max = 50, message = "{product.description.size}")
    private String description;

    @Schema(description = "{product.barCode.schema.description}", required = true)
    @NotEmpty(message = "{product.barCode.notempty}")
    @EAN(message = "{product.barCode.ean}")
    private String barCode;

    @Schema(description = "{product.productType.schema.description}", required = true)
    @NotNull(message = "{product.productType.notempty}")
    private ProductType productType;

    @Schema(description = "{product.unitMeasurement.schema.description}", required = true)
    @NotNull(message = "{product.unitMeasurement.notempty}")
    private UnitMeasurement unitMeasurement;
}
