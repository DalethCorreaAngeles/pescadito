package com.example.pescadito.controller;

import com.example.pescadito.model.Combinado;
import com.example.pescadito.service.CombinadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping ("/api/combinado/")
public class CombinadoController {

    private final CombinadoService combinadoService ;


    public CombinadoController(CombinadoService combinadoService) {
        this.combinadoService = combinadoService;
    }

    @GetMapping
    public List<Combinado> obtenerCombinado(){
        return combinadoService.listarTodas();
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Combinado>
    obtenerCombinadoPorId(@PathVariable Integer id){
        return combinadoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?>
    crearCombinado(@RequestBody Combinado combinado){
        if (Combinado.getNombre() == null   || Combinado.getNombre().trim().isEmpty()){
            return ResponseEntity.badRequest().body("El campo nombre es obligatorio");
        }
        if (combinado.getCatergoria() == null || combinado.getCatergoria().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("El campo categoria es obligatorio");
        }

        if (combinado.getPrecio() <= 0) {
            return ResponseEntity.badRequest().body("El precio debe ser mayor a 0");
        }
        return ResponseEntity.ok(combinadoService.crearCombinado(combinado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarCombinado(
            @PathVariable Integer id,
            @RequestBody Combinado combinado) {

        if (!combinadoService.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        combinado.setId(id);
        return ResponseEntity.ok(combinadoService.actualizarCombinado(id, combinado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCombinado(@PathVariable Integer id) {
        if (!combinadoService.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        combinadoService.eliminarCombinado(id);
        return ResponseEntity.noContent().build();
    }
}
