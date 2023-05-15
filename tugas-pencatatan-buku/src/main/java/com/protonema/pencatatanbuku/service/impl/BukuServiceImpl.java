package com.protonema.pencatatanbuku.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.protonema.pencatatanbuku.entity.Buku;
import com.protonema.pencatatanbuku.repository.BukuRepository;
import com.protonema.pencatatanbuku.service.BukuService;

@Service
public class BukuServiceImpl implements BukuService{


    @Autowired
    BukuRepository bukuRepository;

    @Override
    public void addBuku(Buku buku) {
        bukuRepository.save(buku);
    }

    @Override
    public List<Buku> getAllBuku() {
       return bukuRepository.findAll();
    }

    @Override
    public Optional<Buku> getBukuById(Long id) {
       Optional<Buku> buku = bukuRepository.findById(id);

       return buku;
    }

    @Override
    public void updateJudul(String judul, Long id) {
        bukuRepository.updateJudul(judul, id);
    }

    @Override
    public void deleteBukuById(Long id) {
        bukuRepository.deleteById(id);
    }

    public List<Buku> findByJudul(String judul) {
        return bukuRepository.findByJudul(judul);
    }

    public List<Buku> findByAuthor(String author) {
        return bukuRepository.findByAuthor(author);
    }

    public List<Buku> getByTahunrilis(Integer tahunrilis) {
        return bukuRepository.findByTahunrilis(tahunrilis);
    }

    public Buku updateBuku(Long id, int tahunrilis, String judul, String author) throws NotFoundException {
        Optional<Buku> optionalBuku = bukuRepository.findById(id);
        
        if (optionalBuku.isPresent()) {
            Buku buku = optionalBuku.get();
            buku.setTahunrilis(tahunrilis);
            buku.setJudul(judul);
            buku.setAuthor(author);
            return bukuRepository.save(buku);
        } else {
            throw new NotFoundException();
        }
    }
}
