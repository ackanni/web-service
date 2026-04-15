package com.example.web_service.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.web_service.DAO.EstudanteDAO;
import com.example.web_service.Model.Estudante;

@RestController
@RequestMapping("/api/estudantes")
public class EstudanteController {

    @Autowired
    private EstudanteDAO estudanteDAO;

    // LISTAR TODOS
    @GetMapping
    public Iterable<Estudante> listar() {
        return estudanteDAO.findAll();
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public Estudante buscar(@PathVariable Long id) {
        return estudanteDAO.findById(id).orElse(null);
    }

    // CRIAR
    @PostMapping
    public Estudante criar(@RequestBody Estudante estudante) {
        return estudanteDAO.save(estudante);
    }

    // ATUALIZAR
    @PutMapping("/{id}")
    public Estudante atualizar(@PathVariable Long id, @RequestBody Estudante estudante) {
        if (estudanteDAO.existsById(id)) {
            estudante.setId(id);
            return estudanteDAO.save(estudante);
        }
        return null;
    }

    // DELETAR
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        estudanteDAO.deleteById(id);
    }
}