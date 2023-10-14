package com.javaspring.javaspringapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Importações necessárias para o código.
// Elas trazem classes e funcionalidades de outras partes do código e de bibliotecas externas.

// Esta classe é um controlador Spring MVC que lida com requisições relacionadas aos alunos.
@Controller
// Todas as requisições a este controlador começarão com "/alunos".
@RequestMapping("/alunos")
public class AlunoController {

    // Injeção de dependência do repositório de alunos.
    // Isso permite que o controlador acesse e utilize os métodos do repositório sem a necessidade de criar uma instância.
    @Autowired
    private AlunoRepository alunoRepository;

    // Método que responde a requisições GET para "/alunos/inserir".
    @GetMapping("/inserir")
    public String mostrarFormulario() {
        // Retorna o nome da página Thymeleaf (inserir_aluno.html) para o navegador.
        // Isso indica qual página deve ser exibida ao usuário.
        return "inserir_aluno";
    }

    // Método que responde a requisições POST para "/alunos/salvar".
    // Ele recebe um objeto Aluno preenchido com dados do formulário.
    @PostMapping("/salvar")
    public String salvarAluno(@ModelAttribute Aluno aluno, Model model) {
        // Salva o objeto Aluno no banco de dados usando o repositório.
        alunoRepository.save(aluno);

        // Adiciona uma mensagem ao modelo para ser exibida na página de mensagem.
        model.addAttribute("mensagem", "Aluno salvo com sucesso!");

        // Retorna o nome da página Thymeleaf (mensagem.html) para o navegador.
        return "mensagem";
    }

    // Método que responde a requisições GET para "/alunos".
    public String listarTodos(Model model) {
        // Obtém uma lista de todos os alunos do banco de dados usando o repositório.
        List<Aluno> alunos = alunoRepository.findAll();

        // Adiciona a lista de alunos ao modelo para ser exibida na página lista_alunos.html.
        model.addAttribute("alunos", alunos);

        // Retorna o nome da página Thymeleaf (lista_alunos.html) para o navegador.
        return "lista_alunos";
    }

    // Método que responde a requisições DELETE para "/alunos/{id}".
    public String deletar(@PathVariable Long id) {
        // Deleta um aluno do banco de dados usando o repositório.
        alunoRepository.deleteById(id);

        // Redireciona o navegador para a página de lista de alunos após a deleção.
        return "redirect:/alunos";
    }
}
