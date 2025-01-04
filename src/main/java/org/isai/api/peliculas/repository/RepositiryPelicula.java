package org.isai.api.peliculas.repository;

import org.isai.api.peliculas.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositiryPelicula extends JpaRepository<Pelicula, Integer> {

}
