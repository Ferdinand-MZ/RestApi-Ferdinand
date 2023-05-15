package com.protonema.pencatatanbuku.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.protonema.pencatatanbuku.entity.Buku;
import com.protonema.pencatatanbuku.repository.BukuRepository;
import com.protonema.pencatatanbuku.service.BukuService;
import com.protonema.pencatatanbuku.service.impl.BukuServiceImpl;

@RestController
@RequestMapping("/api/buku")
public class BukuController {
    
    @Autowired
    BukuServiceImpl bukuService;
    BukuRepository bukuRepository;

    // Post
    @PostMapping
    public ResponseEntity addBuku(@RequestBody Buku buku){
        bukuService.addBuku(buku);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    // Get
    @GetMapping
    public ResponseEntity getAllBuku(){
        List<Buku> bukus = bukuService.getAllBuku();

        return ResponseEntity.ok(bukus);
    }

    @GetMapping
    @RequestMapping("/detail")
    public ResponseEntity getBukuById(@RequestParam Long id){
        Optional<Buku> buku = bukuService.getBukuById(id);

        return ResponseEntity.ok(buku);
    }

    
    // Put
    @PutMapping
    public ResponseEntity updateJudul(@RequestParam Long id, @RequestBody Buku buku){
        bukuService.updateJudul(buku.getJudul(), id);
        
        return ResponseEntity.ok(HttpStatus.OK);
    }

    // Delete
    @DeleteMapping
    public ResponseEntity deleteBukuById(@RequestParam Long id) {
        bukuService.deleteBukuById(id);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    
    @GetMapping("/judul")
    public List<Buku> findByJudul(@RequestParam String judul) {
        return bukuService.findByJudul(judul);
    }

    @GetMapping("/author")
    public List<Buku> findByAuthor(@RequestParam String author) {
        return bukuService.findByAuthor(author);
    }

    @GetMapping("/tahunrilis")
    public List<Buku> getByTahunrilis(@RequestParam Integer tahunrilis) {
        return bukuService.getByTahunrilis(tahunrilis);
    }

    @PutMapping("/update/{id}")
    public Buku updateBuku(
            @PathVariable("id") Long id,
            @RequestParam("tahunrilis") int tahunrilis,
            @RequestParam("judul") String judul,
            @RequestParam("author") String author) throws NotFoundException {
        return bukuService.updateBuku(id, tahunrilis, judul, author);
    }
}
