package com.vedik.pocketshield.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="psuser")
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class PSUser extends BaseEntity
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="email")
    private String email;

    @Column(name="address")
    private String address;

    @Column(name="phone_number")
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="psrole_id")
    private PSRole role;
}

