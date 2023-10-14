package com.javaspring.javaspringapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping("/inserir")
    public String mostrarFormulario() {
        return "inserir_aluno";
    }

    @PostMapping("/salvar")
    public String salvarAluno(@ModelAttribute Aluno aluno, Model model) {
        alunoRepository.save(aluno);
        model.addAttribute("mensagem", "Aluno salvo com sucesso!");
        return "mensagem";
    }

    @GetMapping
    public String listarTodos(Model model) {
        List<Aluno> alunos = alunoRepository.findAll();
        model.addAttribute("alunos", alunos);
        return "lista_alunos";
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id) {
        alunoRepository.deleteById(id);
        return "redirect:/alunos";
    }
}
