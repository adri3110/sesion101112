package com.example.sesion101112.controller;

import com.example.sesion101112.entities.Laptop;
import com.example.sesion101112.repository.LaptopRepository;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    private final Logger log = LoggerFactory.getLogger(LaptopController.class);

    private LaptopRepository laptopRepository;

    public LaptopController (LaptopRepository laptopRepository){
        this.laptopRepository = laptopRepository;
    }
    //Buscar todos los laptops
    @GetMapping("api/laptops")
    @ApiOperation("Buscar todos los portátiles")
    public List<Laptop> findAll(){
        // recuperar y devolver los portatiles de la base de datos
        return laptopRepository.findAll();
    }
    //Buscar un laptop
    @GetMapping("/api/laptops/{id}")
    @ApiOperation("Buscar un portatil por clave primaria id Long")
    public ResponseEntity<Laptop> findOneById(@PathVariable Long id){
        Optional<Laptop> laptopOpt = laptopRepository.findById(id);
        // opcion 1
        if(laptopOpt.isPresent()){
            return ResponseEntity.ok(laptopOpt.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }

        // opcion 2
        // return laptopOpt.orElse(null);
    }
    //Crear un laptop
    @PostMapping("/api/laptops")
    @ApiOperation("Crear un portatil")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop){
        // guardar el libro recibido opr parámetro en la base de datos
        if(laptop.getId() != null){
            log.warn("trying to create a laptop with id");
            return ResponseEntity.badRequest().build();
        }
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result); // el portatil devuelto tiene la clave primaria
    }
    //Actualizar un laptop
    @PutMapping("/api/laptops")
    @ApiOperation("Actualizar un portatil")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){
        if(laptop.getId() == null){
            log.warn("trying to update a non existent laptop");
            return ResponseEntity.badRequest().build();
        }
        if(!laptopRepository.existsById(laptop.getId())){
            log.warn("trying to create a laptop with id");
            return ResponseEntity.notFound().build();
        }
        // El proceso de actualización
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }
    //Borrar un laptop
    @DeleteMapping("/api/laptops/{id}")
    @ApiOperation("Borrar un portatil por clave primaria id Long")
    public ResponseEntity<Laptop> deleteOneById(@PathVariable Long id){
        if(!laptopRepository.existsById(id)){
            log.warn("trying to delete a laptop with id");
            return ResponseEntity.notFound().build();
        }
        laptopRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
    //Borrar todos los laptops
    @DeleteMapping("/api/laptops")
    @ApiOperation("Borrar todos los portátiles")
    public ResponseEntity<Laptop> deleteAll(){
        log.info("REST request for delete all laptops");
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }






    /*
    // CRUD
    // findAll()
    @GetMapping("/api/laptops")
    @ApiOperation("Metodo para listar todos los elementos")
    public List<Laptop> findAll(){
        return repository.findAll();
    }

    // fingOneById()
    @GetMapping("/api/laptops/{id}")
    @ApiOperation("Metodo para listar un elemento segun su id")
    public ResponseEntity<Laptop> findOneById(@ApiParam("Clave primaria tipo Long") @PathVariable Long id){
        Optional<Laptop> laptopOpt = repository.findById(id);
        return laptopOpt.isPresent() ? ResponseEntity.ok(laptopOpt.get()) : ResponseEntity.notFound().build();
    }

    // create()
    @PostMapping("/api/laptops")
    @ApiOperation("Metodo para crear un elemento")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop){
        return laptop.getId()!=null ? ResponseEntity.badRequest().build() : ResponseEntity.ok(repository.save(laptop));
    }

    // update()
    @PutMapping("/api/laptops")
    @ApiOperation("Metodo para actualizar un elemento")
    public ResponseEntity<Laptop> update(Laptop laptop){
        if(laptop.getId()==null){
            return ResponseEntity.badRequest().build();
        }
        if (!repository.findById(laptop.getId()).isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(repository.save(laptop));
    }

    // delete()
    @DeleteMapping("/api/laptops/{id}")
    @ApiOperation("Metodo para eliminar un elemento segun su id")
    public ResponseEntity<Laptop> deleteById(@ApiParam("Clave primaria tipo Long") @PathVariable Long id){
        if (!repository.findById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // deleteAll()
    @DeleteMapping("/api/laptops")
    @ApiOperation("Metodo para eliminar todos los elementos")
    // @ApiIgnore - Evita mostrar los metodos en Swagger
    public ResponseEntity<Laptop> deleteAll() {
        repository.deleteAll();
        return ResponseEntity.noContent().build();
    }

     */
}
