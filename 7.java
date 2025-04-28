@GetMapping("/media")
public Double calcularMedia() {
        return alunos.stream()
        .mapToDouble(Aluno::getNota)
        .average()
        .orElse(0.0);
        }