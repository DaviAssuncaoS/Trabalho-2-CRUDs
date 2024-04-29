package br.com.portoseguro.products.entity;

import br.com.portoseguro.products.enums.Status;
import jakarta.persistence.*;
import lombok.*;


@Table(name = "supplier")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_id_supplier")
    @SequenceGenerator(name =  "sequence_id_supplier", sequenceName = "sequence_id_supplier", allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "contact", nullable = false)
    private String contact;

    @Column(name = "product_supplied", nullable = false)
    private String productSupplied;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;
}