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