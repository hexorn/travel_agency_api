package com.epam.finaltask.model;

import java.time.LocalDate;
import java.util.UUID;

import com.epam.finaltask.utils.UuidV7Generator;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@Entity
@Table(name = "vouchers")
public class Voucher {
    @Id
    @GeneratedValue(generator = "uuid7")
    @GenericGenerator(name = "uuid7", type = UuidV7Generator.class)
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TourType tourType;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TransferType transferType;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private HotelType hotelType;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private VoucherStatus status;

    @Column(nullable = false)
    private LocalDate arrivalDate;

    @Column(nullable = false)
    private LocalDate evictionDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private Boolean isHot;


}
