package ps2.teoriab1;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
public class EstudanteController {
    private List<Estudante> estudantes;

    public EstudanteController() {
        estudantes = new ArrayList<>();
        estudantes.add(new Estudante(1L, "Ana Paula Souza", 2024001, "ana.souza@email.com", "2002-03-15", 2020));
        estudantes.add(new Estudante(2L, "Carlos Henrique Lima", 2024002, "carlos.lima@email.com", "2001-10-22", 2019));
        estudantes.add(new Estudante(3L, "Fernanda Oliveira", 2024003, "fernanda.oliveira@email.com", "2003-07-05", 2021));
        estudantes.add(new Estudante(4L, "Lucas Pereira", 2024004, "lucas.pereira@email.com", "2002-04-11", 2020));
        estudantes.add(new Estudante(5L, "Gabriela Martins", 2024005, "gabriela.martins@email.com", "2001-12-25", 2019));
        estudantes.add(new Estudante(6L, "Rafael Costa", 2024006, "rafael.costa@email.com", "2000-09-13", 2018));
        estudantes.add(new Estudante(7L, "Juliana Silva", 2024007, "juliana.silva@email.com", "2002-06-18", 2020));
        estudantes.add(new Estudante(8L, "Marcos Vinícius", 2024008, "marcos.vinicius@email.com", "2003-01-30", 2021));
        estudantes.add(new Estudante(9L, "Camila Azevedo", 2024009, "camila.azevedo@email.com", "2001-11-08", 2019));
        estudantes.add(new Estudante(10L, "Felipe Cardoso", 2024010, "felipe.cardoso@email.com", "2000-08-27", 2018));
    }

    @GetMapping("/api/estudantes")
    public List<Estudante> getEstudantes() {
        return estudantes;
    }

    @GetMapping("/api/estudantes/{id}")
    public Estudante getEstudante(@PathVariable long id) {
        for (Estudante e : estudantes) {
            if (id == e.getId()) return e;
        }
        return null;
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
    