package org.isai.api.peliculas.controller;

import java.net.URI;
import java.util.List;
import org.isai.api.peliculas.model.Pelicula;
import org.isai.api.peliculas.service.PeliculaSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

    @Autowired
    private PeliculaSevice service;

    @PostMapping
    public ResponseEntity<?> registrerPelicula(@RequestBody Pelicula pelicula) {
        service.registrerPelicula(pelicula);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{idPelicula}")
                .buildAndExpand(pelicula.getId())
                .toUri(); //finaliza la construccion de la URI 
//retornamos el codigo de respuesta
//        return ResponseEntity
//                .created(location)
//                .build();

//para retornar el objeto en el body
        return ResponseEntity
                .created(location)
                .body(pelicula);
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
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Pelicula no encontrado con ID: " + idPelicula);
        }
    }

    @PutMapping("/{idPelicula}")
    public ResponseEntity<?> updatePelicula(@RequestBody Pelicula pelicula, @PathVariable Integer idPelicula) {
        try {
            service.updatePelicula(pelicula, idPelicula);
            return new ResponseEntity<Pelicula>(service.getPelicula(idPelicula), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Pelicula no encontrado con ID: " + idPelicula);
        }
    }

    @DeleteMapping("/{idPelicula}")
    public ResponseEntity<?> deletePelicula(@PathVariable Integer idPelicula) {
        try {
            service.deletePelicula(idPelicula);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).
                    body("Pelicula no encontrada con ID: " + idPelicula);
        }
    }
}
