package com.example.demo.controller;

import com.example.demo.model.Aluno;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private List<Aluno> alunos = new ArrayList<>(Arrays.asList(
            new Aluno(1L, "João Silva", "joao@email.com", 8.5),
            new Aluno(2L, "Maria Souza", "maria@email.com", 6.0),
            new Aluno(3L, "Carlos Lima", "carlos@email.com", 7.2)
    ));


    @GetMapping("/bem-vindo")
    public String boasVindas(@RequestParam String nome) {
        return "Bem-vindo " + nome + "!";
    }


    @GetMapping("/aprovados")
    public List<Aluno> getAprovados() {
        return alunos.stream()
                .filter(aluno -> aluno.getNota() >= 7.0)
                .collect(Collectors.toList());
    }


    @GetMapping("/email/{email}")
    public Aluno getAlunoPorEmail(@PathVariable String email) {
        return alunos.stream()
                .filter(aluno -> aluno.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }


    @PutMapping("/{id}/nota")
    public String atualizarNota(@PathVariable Long id, @RequestBody Map<String, Double> body) {
        Double novaNota = body.get("nota");
        for (Aluno aluno : alunos) {
            if (aluno.getId().equals(id)) {
                aluno.setNota(novaNota);
                return "Nota atualizada com sucesso!";
            }
        }
        return "Aluno não encontrado.";
    }


    @DeleteMapping("/{id}")
    public String removerAluno(@PathVariable Long id) {
        boolean removed = alunos.removeIf(aluno -> aluno.getId().equals(id));
        return removed ? "Aluno removido com sucesso!" : "Aluno não encontrado.";
    }


    @GetMapping("/ordenados")
    public List<Aluno> listarOrdenados() {
        return alunos.stream()
                .sorted(Comparator.comparing(Aluno::getNome))
                .collect(Collectors.toList());
    }


    @GetMapping("/media")
    public Double calcularMedia() {
        return alunos.stream()
                .mapToDouble(Aluno::getNota)
                .average()
                .orElse(0.0);
    }


    @GetMapping("/quantidade")
    public int quantidadeAlunos() {
        return alunos.size();
    }


    @GetMapping("/relatorio")
    public Map<String, Object> gerarRelatorio() {
        Map<String, Object> relatorio = new HashMap<>();
        long aprovados = alunos.stream().filter(aluno -> aluno.getNota() >= 7.0).count();
        long reprovados = alunos.size() - aprovados;
        double maiorNota = alunos.stream().mapToDouble(Aluno::getNota).max().orElse(0.0);
        double menorNota = alunos.stream().mapToDouble(Aluno::getNota).min().orElse(0.0);

        relatorio.put("totalAlunos", alunos.size());
        relatorio.put("numeroAprovados", aprovados);
        relatorio.put("numeroReprovados", reprovados);
        relatorio.put("maiorNota", maiorNota);
        relatorio.put("menorNota", menorNota);

        return relatorio;
    }
}