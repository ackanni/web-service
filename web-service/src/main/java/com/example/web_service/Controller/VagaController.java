package ps2.teoriab1;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
public class VagaController {
    private List<Vaga> vagas;

    public VagaController() {
        vagas = new ArrayList<>();
        vagas.add(new Vaga(1L, "Desenvolvedor Java", "Atuação em projetos backend...", "2025-10-01", true, 1L));
        vagas.add(new Vaga(2L, "Analista de Suporte Técnico", "Suporte a clientes...", "2025-09-27", true, 2L));
        vagas.add(new Vaga(3L, "Engenheiro de Software", "Desenvolvimento de soluções...", "2025-10-03", false, 3L));
        vagas.add(new Vaga(4L, "Analista de Dados", "Manipulação e análise...", "2025-09-18", true, 4L));
        vagas.add(new Vaga(5L, "Designer Digital", "Criação de materiais...", "2025-09-30", false, 5L));
        vagas.add(new Vaga(6L, "Consultor de Projetos", "Elaboração e acompanhamento...", "2025-10-06", true, 1L));
        vagas.add(new Vaga(7L, "Programador Full Stack", "Desenvolvimento de aplicações...", "2025-10-04", true, 2L));
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
}