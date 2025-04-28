@GetMapping("/ordenados")
public List<Aluno> listarOrdenados() {
        return alunos.stream()
        .sorted(Comparator.comparing(Aluno::getNome))
        .collect(Collectors.toList());
        }