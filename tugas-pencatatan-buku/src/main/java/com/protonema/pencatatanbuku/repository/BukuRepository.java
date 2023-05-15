package com.protonema.pencatatanbuku.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.protonema.pencatatanbuku.entity.Buku;

import jakarta.transaction.Transactional;

public interface BukuRepository extends JpaRepository<Buku, Long> {
    
    @Transactional
    @Modifying
    @Query(value = "UPDATE t_buku SET judul=:judul WHERE buku_id=:id", nativeQuery = true)
    
    public void updateJudul(@Param("judul") String judul, @Param("id") Long id);
    List<Buku> findByJudul(String judul);
    List<Buku> findByAuthor(String author);
    List<Buku> findByTahunrilis(Integer tahunrilis);
    Optional<Buku> findById(Long id);
    
}