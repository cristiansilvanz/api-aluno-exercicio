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
    