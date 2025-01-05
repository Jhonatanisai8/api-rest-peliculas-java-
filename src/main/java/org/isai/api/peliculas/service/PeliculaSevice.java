package org.isai.api.peliculas.service;

import java.util.List;
import org.isai.api.peliculas.model.Pelicula;
import org.isai.api.peliculas.repository.RepositiryPelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeliculaSevice {

    @Autowired
    private RepositiryPelicula repositiryPelicula;

    public Pelicula registrerPelicula(Pelicula pelicula) {
        repositiryPelicula.save(pelicula);
        return pelicula;
    }

    public List<Pelicula> getAllPelicula() {
        return repositiryPelicula.findAll();
    }

    public Pelicula getPelicula(Integer idPelicula) {
        return repositiryPelicula.findById(idPelicula).get();
    }

    public Pelicula updatePelicula(Pelicula pelicula, Integer id) {
        Pelicula peliculaBuscada = getPelicula(id);
        peliculaBuscada.setAnioEstreno(pelicula.getAnioEstreno());
        peliculaBuscada.setDirector(pelicula.getDirector());
        peliculaBuscada.setGenero(pelicula.getGenero());
        peliculaBuscada.setSinopsis(pelicula.getSinopsis());
        peliculaBuscada.setTitulo(pelicula.getTitulo());
        registrerPelicula(peliculaBuscada);
        return peliculaBuscada;
    }

    public Pelicula deletePelicula(Integer id) {
        Pelicula p = getPelicula(id);
        repositiryPelicula.delete(p);
        return p;
    }

}
