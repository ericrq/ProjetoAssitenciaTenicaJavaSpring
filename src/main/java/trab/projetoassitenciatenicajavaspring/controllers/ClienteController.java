package trab.projetoassitenciatenicajavaspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import trab.projetoassitenciatenicajavaspring.models.Cliente;
import trab.projetoassitenciatenicajavaspring.models.Produto;
import trab.projetoassitenciatenicajavaspring.repository.ClienteRepository;
import trab.projetoassitenciatenicajavaspring.repository.ProdutoRepository;

//controlador do cliente
@Controller
public class ClienteController {
    // set do repository
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    // rota para sarvar os dados do formulario
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String salvarCliente(Cliente cliente) {
        // uso do repository com save para salvar os dados
        clienteRepository.save(cliente);
        return "redirect:/";
    }

    // rota para a pagina principal
    @RequestMapping("/")
    public ModelAndView listarProdutoIndex() {
        ModelAndView mv = new ModelAndView("index");
        // passagem do objeto produto para a pagina prinicipal, usado para o select
        Iterable<Produto> produto = produtoRepository.findAll();
        mv.addObject("produtos", produto);
        return mv;
    }

    // rota para a pagina de listagem de clientes
    @RequestMapping("/tabelaAdmin")
    public ModelAndView listaClientes() {
        ModelAndView mv = new ModelAndView("tabelaAdmin");
        // passagem do objeto cliente para a pagina de listagem de clientes,
        // usado para mostrar os dados pelo tymeleaf
        Iterable<Cliente> clientes = clienteRepository.findAll();
        mv.addObject("clientes", clientes);
        return mv;
    }

    // rota para a pagina de edição de clientes, pegando o id pela url
    @RequestMapping(value = "/editarCliente/{id}", method = RequestMethod.GET)
    public ModelAndView editarCliente(@PathVariable("id") long id) {
        // usando o id pego pela url para buscar o cliente no banco de dados
        Cliente cliente = clienteRepository.findById(id);
        Iterable<Produto> produtos = produtoRepository.findAll();
        ModelAndView mv = new ModelAndView("editarCliente");
        // passagem do objeto cliente para a pagina de edição de clientes, usado para mostrar os dados pelo tymeleaf
        mv.addObject("clientes", cliente);
        // passagem do objeto produto para a pagina de edição de clientes, usado para o select
        mv.addObject("produtos", produtos);
        return mv;
    }

    // rota para salvar os dados editados do formulario
    @RequestMapping(value = "/editarCliente/{id}", method = RequestMethod.POST)
    public String editarCliente(Cliente cliente) {
        // uso do repository com save para salvar os dados editados
        clienteRepository.save(cliente);
        return "redirect:/tabelaAdmin";
    }

    // rota para deletar um cliente, pegando o id pela url
    @RequestMapping(value = "/deletarCliente/{id}", method = RequestMethod.GET)
    public String deletarCliente(@PathVariable("id") long id) {
        // usando o id pego pela url passando para o repository buscar o cliente
        Cliente cliente = clienteRepository.findById(id);
        // uso do repository com delete para deletar o cliente
        clienteRepository.delete(cliente);
        return "redirect:/tabelaAdmin";
    }
}