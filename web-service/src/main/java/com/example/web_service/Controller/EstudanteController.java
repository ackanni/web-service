package com.example.web_service.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.web_service.DAO.EstudanteDAO;
import com.example.web_service.Model.Estudante;

@RestController
public class EstudanteController {
    @Autowired;
    private EstudanteDAO estudanteDAO;


    public EstudanteController() {
    }
    
    @GetMapping("/api/estudantes")
    public Iterable<Estudante> getAllEstudantes() {
        return this.estudanteDAO.findAll();
    }

    @GetMapping("/api/estudantes/{id}")
    public Estudante getEstudanteById(@PathVariable long id) {
        return this.estudanteDAO.findById(id).get();
    }

    @PostMapping("/api/estudantes")
    public Estudante create(@RequestBody Estudante e) {
        long maior = 0;
        for (Estudante est : estudantes) {
            if (est.getId() > maior) maior = est.getId();
        }
        e.setId(maior + 1);
        estudantes.add(e);
        return e;
    }

    // --- POST (Criar) ---
    @PostMapping("/mackenzie/alunos")
    public Estudante create(@RequestBody Estudante e){
        long maior = 0;
        for(Estudante estudante : estudantes){
            if (estudante.getId() > maior){
                maior = estudante.getId();
            }
        }
        e.setId(maior + 1);
        estudantes.add(e);
        return e;
    }

    // --- PUT (Atualizar) ---
    @PutMapping("/mackenzie/alunos/{id}")
    public Estudante update(@PathVariable long id, @RequestBody Estudante estudanteAtualizado) {
        for (Estudante e : estudantes) {
            if (e.getId() == id) {
                e.setNome(estudanteAtualizado.getNome());
                e.setRa(estudanteAtualizado.getRa());
                e.setCurso(estudanteAtualizado.getCurso());
                return e; // Retorna o estudante atualizado
            }
        }
        return null; // Retorna null se não encontrar o estudante
    }

    // --- DELETE (Remover) ---
    @DeleteMapping("/mackenzie/alunos/{id}")
    public String delete(@PathVariable long id) {
        // Usa o método removeIf do Java 8+ para remover caso o ID bata
        boolean removido = estudantes.removeIf(e -> e.getId() == id);
        
        if (removido) {
            return "Estudante com ID " + id + " removido com sucesso.";
        } else {
            return "Estudante com ID " + id + " não encontrado.";
        }
    }
}
    