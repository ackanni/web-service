package com.example.web_service.DAO;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.example.web_service.Model.Vaga;

public interface VagaDAO extends CrudRepository <Vaga, Long> {

}
