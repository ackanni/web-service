package com.example.web_service.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.web_service.DAO.VagaDAO;
import com.example.web_service.Model.Vaga;

@RestController
public class VagaController {
    @Autowired;
    private VagaDAO vagaDAO;

    public VagaController() {
    }

    @GetMapping("/api/vagas")
    public List<Vaga> getVagas() {
        return vagas;
    }

    @GetMapping("/api/vagas/{id}")
    public Vaga getVaga(@PathVariable long id) {
        for (Vaga v : vagas) {
            if (id == v.getId()) return v;
        }
        return null;
    }

    @PostMapping("/api/vagas")
    public Vaga create(@RequestBody Vaga v) {
        long maior = 0;
        for (Vaga vaga : vagas) {
            if (vaga.getId() > maior) maior = vaga.getId();
        }
        v.setId(maior + 1);
        vagas.add(v);
        return v;
    }

    @PutMapping("/{id}")
    public Vaga update(@PathVariable long id, @RequestBody Vaga vAtt) {
        for (Vaga v : vagas) {
            if (v.getId() == id) {
                v.setTitulo(vAtt.getTitulo());
                v.setDescricao(vAtt.getDescricao());
                v.setSalario(vAtt.getSalario());
                return v;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id) {
        return vagas.removeIf(v -> v.getId() == id) ? "Vaga removida." : "Não encontrada.";
    }
}
