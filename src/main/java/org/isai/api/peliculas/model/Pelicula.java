package org.isai.api.peliculas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "titulo", nullable = false)
    private String titulo;
    @Column(name = "director", nullable = false)
    private String director;
    @Column(name = "anio_estreno")
    private int anioEstreno;
    @Column(name = "genero")
    private String genero;
    @Column(name = "sinopsis")
    private String sinopsis;

    public Pelicula() {
    }

    public Pelicula(Integer id, String titulo, String director, int anioEstreno, String genero, String sinopsis) {
        this.id = id;
        this.titulo = titulo;
        this.director = director;
        this.anioEstreno = anioEstreno;
        this.genero = genero;
        this.sinopsis = sinopsis;
    }

    public Pelicula(String titulo, String director, int anioEstreno, String genero, String sinopsis) {
        this.titulo = titulo;
        this.director = director;
        this.anioEstreno = anioEstreno;
        this.genero = genero;
        this.sinopsis = sinopsis;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String direcctor) {
        this.director = direcctor;
    }

    public int getAnioEstreno() {
        return anioEstreno;
    }

    public void setAnioEstreno(int anioEstreno) {
        this.anioEstreno = anioEstreno;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

}
