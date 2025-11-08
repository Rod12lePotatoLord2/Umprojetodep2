package com.gestao_habitos_saudaveis.controller;

import com.gestao_habitos_saudaveis.exception.BadRequestException;
import com.gestao_habitos_saudaveis.exception.ResourceNotFoundException;
import com.gestao_habitos_saudaveis.model.Habito;
import com.gestao_habitos_saudaveis.service.HabitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/habitos")
public class HabitoController {

    private final HabitoService habitoService;

    @Autowired
    public HabitoController(HabitoService habitoService) {
        this.habitoService = habitoService;
    }

    @GetMapping
    public ResponseEntity<List<Habito>> listarTodos() {
        List<Habito> habitos = habitoService.listarTodos();
        return ResponseEntity.ok(habitos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Habito> buscarPorId(@PathVariable String id) {
        try {
            Habito habito = habitoService.buscarPorId(id);
            return ResponseEntity.ok(habito);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<?> criar(@RequestBody Habito habito) {
        try {
            Habito novoHabito = habitoService.criar(habito);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoHabito);
        } catch (BadRequestException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable String id, @RequestBody Habito habito) {
        try {
            Habito atualizado = habitoService.atualizar(id, habito);
            return ResponseEntity.ok(atualizado);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (BadRequestException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable String id) {
        try {
            habitoService.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
