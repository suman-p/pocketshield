package com.vedik.pocketshield.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="psrole")
@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class PSRole extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "role_name")
    private String roleName;
}
