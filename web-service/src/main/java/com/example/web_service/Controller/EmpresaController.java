package com.example.web_service.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.web_service.DAO.EmpresaDAO;
import com.example.web_service.Model.Empresa;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaDAO empresaDAO;

    // LISTAR TODAS
    @GetMapping
    public Iterable<Empresa> listar() {
        return empresaDAO.findAll();
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public Empresa buscar(@PathVariable Long id) {
        return empresaDAO.findById(id).orElse(null);
    }

    // CRIAR
    @PostMapping
    public Empresa criar(@RequestBody Empresa empresa) {
        return empresaDAO.save(empresa);
    }

    // ATUALIZAR
    @PutMapping("/{id}")
    public Empresa atualizar(@PathVariable Long id, @RequestBody Empresa empresa) {
        if (empresaDAO.existsById(id)) {
            empresa.setId(id);
            return empresaDAO.save(empresa);
        }
        return null;
    }

    // DELETAR
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        empresaDAO.deleteById(id);
    }
}