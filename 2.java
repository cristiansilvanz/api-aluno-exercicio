@GetMapping("/aprovados")
public List<Aluno> getAprovados() {
        return alunos.stream()
        .filter(aluno -> aluno.getNota() >= 7.0)
        .collect(Collectors.toList());
        }