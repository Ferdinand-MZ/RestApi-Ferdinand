package com.protonema.pencatatanbuku.service;

import java.util.List;
import java.util.Optional;

import com.protonema.pencatatanbuku.entity.Buku;

public interface BukuService {
    public void addBuku(Buku buku);

    public List<Buku> getAllBuku();

    public Optional<Buku> getBukuById(Long id);

    public void updateJudul(String judul, Long id);

    public void deleteBukuById(Long id);
}
