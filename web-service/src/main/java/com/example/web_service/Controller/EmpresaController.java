package ps2.teoriab1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.web_service.Model.Empresa;

@RestController
public class EmpresaController {
    @Autowired;
    private EmpresaDAO empresaDAO;



    public EmpresaController() {
    }  
    @GetMapping("/api/empresas")
    public Iterable<Empresa> getEmpresas() {
        return empresaDAO.findAll();
    }

    @GetMapping("/api/empresas/{id}")
    public Empresa getEmpresa(@PathVariable long id) {
        return empresaDAO.findById(id).orElse(null);
    }

    @PostMapping("/api/empresas")
    public Empresa create(@RequestBody Empresa e) {
        return empresaDAO.save(e);
    }

    @PutMapping("/api/empresas/{id}")
    public Empresa update(@PathVariable long id, @RequestBody Empresa eAtt) {
        return empresaDAO.findById(id).map(e -> {
            e.setNome(eAtt.getNome());
            e.setCnpj(eAtt.getCnpj());
            return empresaDAO.save(e);
        }).orElse(null);
    }

    @DeleteMapping("/api/empresas/{id}")
    public String delete(@PathVariable long id) {
        empresaDAO.deleteById(id);
        return "Empresa removida.";
    }
}
            if (id == emp.getId()) return emp;
        }
        return null;
    }

    @PostMapping("/api/empresas")
    public Empresa create(@RequestBody Empresa e) {
        long maior = 0;
        for (Empresa emp : empresas) {
            if (emp.getId() > maior) maior = emp.getId();
        }
        e.setId(maior + 1);
        empresas.add(e);
        return e;
    }


    @PutMapping("/{id}")
    public Empresa update(@PathVariable long id, @RequestBody Empresa eAtt) {
        for (Empresa e : empresas) {
            if (e.getId() == id) {
                e.setNome(eAtt.getNome());
                e.setCnpj(eAtt.getCnpj());
                return e;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id) {
        return empresas.removeIf(e -> e.getId() == id) ? "Empresa removida." : "Não encontrada.";
    }
}