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