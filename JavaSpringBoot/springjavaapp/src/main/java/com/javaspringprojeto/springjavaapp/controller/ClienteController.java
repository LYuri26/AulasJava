package com.javaspringprojeto.springjavaapp.controller;

import com.javaspringprojeto.springjavaapp.model.Cliente; // Importa a classe Cliente do pacote model
import com.javaspringprojeto.springjavaapp.repository.ClienteRepository; // Importa a interface ClienteRepository do pacote repository
import org.springframework.beans.factory.annotation.Autowired; // Importa a anotação @Autowired do Spring Framework
import org.springframework.stereotype.Controller; // Importa a anotação @Controller do Spring Framework
import org.springframework.ui.Model; // Importa a classe Model do Spring Framework
import org.springframework.web.bind.annotation.*; // Importa as anotações @GetMapping, @PostMapping, @ModelAttribute e @PathVariable do Spring Framework
import java.util.List; // Importa a interface List do pacote java.util

@Controller // Indica que essa classe é um controlador do Spring MVC
@RequestMapping("/") // Define o prefixo de URL para os métodos desta classe
public class ClienteController {

    @Autowired // Injeta uma instância de ClienteRepository automaticamente pelo Spring
               // Framework
    private ClienteRepository clienteRepository; // Declaração da variável clienteRepository do tipo ClienteRepository

    @GetMapping("/formulario") // Mapeamento GET para a rota /formulario
    public String exibirFormularioCliente(Model model) { // Método que recebe um objeto Model como argumento
        model.addAttribute("cliente", new Cliente()); // Adiciona um novo objeto Cliente ao modelo
        return "formulario-cliente"; // Retorna o nome da página (formulario-cliente.html)
    }

    @PostMapping("/salvar") // Mapeamento POST para a rota /salvar
    public String salvarCliente(@ModelAttribute Cliente cliente) { // Método que recebe um objeto Cliente como argumento
        clienteRepository.save(cliente); // Salva o cliente usando o repositório
        return "mensagem"; // Retorna o nome da página (mensagem.html)
    }

    @GetMapping("/lista") // Mapeamento GET para a rota /lista
    public String listarClientes(Model model) { // Método que recebe um objeto Model como argumento
        List<Cliente> clientes = clienteRepository.findAll(); // Obtém a lista de todos os clientes
        model.addAttribute("clientes", clientes); // Adiciona a lista de clientes ao modelo
        return "lista-clientes"; // Retorna o nome da página (lista-clientes.html)
    }

    @GetMapping("/edicao/{id}") // Mapeamento GET para a rota /edicao/{id}
    public String mostrarFormularioEdicao(@PathVariable Integer id, Model model) { // Método que recebe um ID e um
                                                                                   // objeto Model como argumentos
        Cliente cliente = clienteRepository.findById(id).orElse(null); // Obtém o cliente com o ID fornecido do
                                                                       // repositório
        model.addAttribute("cliente", cliente); // Adiciona o cliente ao modelo
        return "formulario-edicao-cliente"; // Retorna o nome da página (formulario-edicao-cliente.html)
    }

    @PostMapping("/atualizar") // Mapeamento POST para a rota /atualizar
    public String atualizarCliente(@ModelAttribute Cliente cliente, Model model) { // Método que recebe um objeto
                                                                                   // Cliente e um objeto Model como
                                                                                   // argumentos
        clienteRepository.save(cliente); // Salva o cliente atualizado usando o repositório
        model.addAttribute("mensagem", "Cliente atualizado com sucesso!"); // Adiciona uma mensagem ao modelo
        return "mensagem"; // Retorna o nome da página (mensagem.html)
    }

    @GetMapping("/exclusao/{id}") // Mapeamento GET para a rota /exclusao/{id}
    public String excluirCliente(@PathVariable Integer id) { // Método que recebe um ID como argumento
        clienteRepository.deleteById(id); // Exclui o cliente com o ID fornecido
        return "mensagem"; // Retorna o nome da página (mensagem.html)
    }
}
