@DeleteMapping("/{id}")
public String removerAluno(@PathVariable Long id) {
        boolean removed = alunos.removeIf(aluno -> aluno.getId().equals(id));
        return removed ? "Aluno removido com sucesso!" : "Aluno não encontrado.";
        }