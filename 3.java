@GetMapping("/email/{email}")
public Aluno getAlunoPorEmail(@PathVariable String email) {
        return alunos.stream()
        .filter(aluno -> aluno.getEmail().equalsIgnoreCase(email))
        .findFirst()
        .orElse(null);
        }