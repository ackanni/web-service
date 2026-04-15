package com.example.web_service.DAO;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.example.web_service.Model.Estudante;

public interface EmpresaDao extends CrudRepository<Empresa, Long> {

}
