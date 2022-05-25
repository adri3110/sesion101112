package com.example.sesion101112.entities;


import io.swagger.annotations.ApiModel;

import javax.persistence.*;

@Entity
@Table(name = "laptops")
@ApiModel("Entidad portatil para representar los portatiles del mercado")
public class Laptop {

    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String marca;
    String procesador;
    int memoriaRam;
    int discoDuro;

    //constructor por defecto
    public Laptop(){}

    //constructor
    public Laptop(Long id, String marca, String procesador, int memoriaRam, int discoDuro) {
        this.id = id;
        this.marca = marca;
        this.procesador = procesador;
        this.memoriaRam = memoriaRam;
        this.discoDuro = discoDuro;
    }

    //setters y getters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public int getMemoriaRam() {
        return memoriaRam;
    }

    public void setMemoriaRam(int memoriaRam) {
        this.memoriaRam = memoriaRam;
    }

    public int getDiscoDuro() {
        return discoDuro;
    }

    public void setDiscoDuro(int discoDuro) {
        this.discoDuro = discoDuro;
    }

    //to string

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", procesador='" + procesador + '\'' +
                ", memoriaRam=" + memoriaRam +
                ", discoDuro=" + discoDuro +
                '}';
    }
}
