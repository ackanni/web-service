package com.example.web_service.DAO;

import org.springframework.data.repository.CrudRepository;
import com.example.web_service.Model.Empresa;

public interface EmpresaDAO extends CrudRepository<Empresa, Long> {
}
