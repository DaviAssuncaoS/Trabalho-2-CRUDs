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
public class CreateUpdateProductDTO {

    @Schema(description = "{product.name.schema.description}", required = true)
    @NotEmpty(message = "{product.name.notempty}")
    @Size(max = 50, message = "{product.name.size}")
    private String name;

    @Schema(description = "{product.description.schema.description}", required = true)
    @NotEmpty(message = "{product.description.notempty}")
    @Size(max = 50, message = "{product.description.size}")
    private String description;

}
