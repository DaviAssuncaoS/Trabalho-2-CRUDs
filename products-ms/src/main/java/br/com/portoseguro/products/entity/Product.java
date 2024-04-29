package br.com.portoseguro.products.entity;

import br.com.portoseguro.products.enums.Status;
import jakarta.persistence.*;
import lombok.*;


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
    @SequenceGenerator(name = "sequence_id_product", sequenceName = "sequence_id_product", allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;
}