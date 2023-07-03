package br.com.portoseguro.products.entity;

import br.com.portoseguro.products.enums.ProductType;
import br.com.portoseguro.products.enums.Status;
import br.com.portoseguro.products.enums.UnitMeasurement;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Table(name = "product")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_id_product")
    @SequenceGenerator(name =  "sequence_id_product", sequenceName = "sequence_id_product", allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "bar_code", nullable = false)
    private String barCode;

    @Enumerated(EnumType.STRING)
    @Column(name = "product_type", nullable = false)
    private ProductType productType;

    @Enumerated(EnumType.STRING)
    @Column(name = "unit_measurement", nullable = false)
    private UnitMeasurement unitMeasurement;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;
}