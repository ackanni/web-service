package ps2.teoriab1;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmpresaController {
    private List<Empresa> empresas;

    public EmpresaController() {
        empresas = new ArrayList<>();
        empresas.add(new Empresa(1L, "Empresa Alfa LTDA", "12.345.678/0001-90", "contato@empresa-alfa.com"));
        empresas.add(new Empresa(2L, "Beta Comércio ME", "98.765.432/0001-10", "beta@comercio.com"));
        empresas.add(new Empresa(3L, "Gamma Serviços S.A.", "11.222.333/0001-44", "servicos@gamma.com"));
        empresas.add(new Empresa(4L, "Delta Engenharia", "22.333.444/0001-55", "contato@deltaeng.com"));
        empresas.add(new Empresa(5L, "Epsilon Digital", "33.444.555/0001-66", "email@epsilondigital.com"));
    }

    @GetMapping("/api/empresas")
    public List<Empresa> getEmpresas() {
        return empresas;
    }

    @GetMapping("/api/empresas/{id}")
    public Empresa getEmpresa(@PathVariable long id) {
        for (Empresa emp : empresas) {
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