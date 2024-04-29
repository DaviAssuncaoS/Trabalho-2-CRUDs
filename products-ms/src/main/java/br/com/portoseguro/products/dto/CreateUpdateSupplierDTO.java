package br.com.portoseguro.products.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CreateUpdateSupplierDTO {

    @Schema(description = "{supplier.name.schema.description}", required = true)
    @NotEmpty(message = "{supplier.name.notempty}")
    @Size(max = 50, message = "{supplier.name.size}")
    private String name;

    @Schema(description = "{supplier.address.schema.description}", required = true)
    @NotEmpty(message = "{supplier.address.notempty}")
    @Size(max = 50, message = "{supplier.address.size}")
    private String address;

    @Schema(description = "{supplier.contact.schema.description}", required = true)
    @NotEmpty(message = "{supplier.contact.notempty}")
    @Size(max = 50, message = "{supplier.contact.size}")
    private String contact;

    @Schema(description = "{supplier.productSupplied.schema.description}", required = true)
    @NotEmpty(message = "{supplier.productSupplied.notempty}")
    @Size(max = 50, message = "{supplier.productSupplied.size}")
    private String productSupplied;

}