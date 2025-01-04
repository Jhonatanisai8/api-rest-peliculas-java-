package org.isai.api.peliculas.controller;

import java.util.List;
import org.isai.api.peliculas.model.Pelicula;
import org.isai.api.peliculas.service.PeliculaSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

    @Autowired
    private PeliculaSevice service;

    public ResponseEntity<?> registrerPelicula(@RequestBody Pelicula pelicula) {
        service.registrerPelicula(pelicula);
        return ResponseEntity.status(HttpStatus.CREATED).body(pelicula);
    }

    @GetMapping
    public List<Pelicula> getAllPelicula() {
        return service.getAllPelicula();
    }

    @GetMapping("/{idPelicula}")
    public ResponseEntity<?> getPelicula(@PathVariable Integer idPelicula) {
        try {
            return new ResponseEntity<Pelicula>(service.getPelicula(idPelicula), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity< Pelicula>(HttpStatus.NOT_FOUND);//no se encontro
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePelicula(@RequestBody Pelicula pelicula, @PathVariable Integer id) {
        try {
            service.updatePelicula(pelicula, id);
            return new ResponseEntity<Pelicula>(service.getPelicula(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity< Pelicula>(HttpStatus.NOT_FOUND);//no se encontro
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePelicula(@PathVariable Integer id) {
        try {
            service.deletePelicula(id);
            return new ResponseEntity<Pelicula>(service.getPelicula(id), HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity< Pelicula>(HttpStatus.NOT_FOUND);//no se encontro
        }
    }

}
