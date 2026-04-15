package com.example.web_service.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.web_service.DAO.VagaDAO;
import com.example.web_service.Model.Vaga;

@RestController
@RequestMapping("/api/vagas")
public class VagaController {

    @Autowired
    private VagaDAO vagaDAO;

    // LISTAR TODAS
    @GetMapping
    public Iterable<Vaga> listar() {
        return vagaDAO.findAll();
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public Vaga buscar(@PathVariable Long id) {
        return vagaDAO.findById(id).orElse(null);
    }

    // CRIAR
    @PostMapping
    public Vaga criar(@RequestBody Vaga vaga) {
        return vagaDAO.save(vaga);
    }

    // ATUALIZAR
    @PutMapping("/{id}")
    public Vaga atualizar(@PathVariable Long id, @RequestBody Vaga vaga) {
        if (vagaDAO.existsById(id)) {
            vaga.setId(id);
            return vagaDAO.save(vaga);
        }
        return null;
    }

    // DELETAR
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        vagaDAO.deleteById(id);
    }
}