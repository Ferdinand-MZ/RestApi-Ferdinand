package com.protonema.pencatatanbuku.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_buku")
public class Buku {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long bukuId;
    
    private String judul;
    private Integer tahunrilis;
    private String author;    
}
