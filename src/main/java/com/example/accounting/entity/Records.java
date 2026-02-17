package com.example.accounting.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "records")
@Getter
@Setter
public class Records {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @JsonProperty("user_id")
    @Column(name = "user_id", nullable = false)
    private int userId;

    @JsonProperty("account_id")
    @Column(name = "account_id", nullable = false)
    private int accountId;

    @JsonProperty("category_id")
    @Column(name = "category_id", nullable = false)
    private int categoryId;

    @Column(name = "amount", nullable = false)
    private int amount;

    @Column(name = "type", nullable = false)
    private int type;

    @JsonProperty("record_date")
    @Column(name = "record_date", nullable = false)
    private LocalDate recordDate;

    @Column(name = "note", length = 200)
    private String note;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    public Records() {
    }
}
