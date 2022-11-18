package projeto.assitencia_tecnica.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import projeto.assitencia_tecnica.models.Cliente;
import projeto.assitencia_tecnica.models.Produto;
import projeto.assitencia_tecnica.repository.ClienteRepository;
import projeto.assitencia_tecnica.repository.ProdutoRepository;

@Controller
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String salvarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
        return "redirect:/";
    }

    @RequestMapping("/")
    public ModelAndView listarProdutoIndex() {
        ModelAndView mv = new ModelAndView("index");
        Iterable<Produto> produto = produtoRepository.findAll();
        mv.addObject("produtos", produto);
        return mv;
    }

    @RequestMapping("/tabelaAdmin")
    public ModelAndView listaClientes() {
        ModelAndView mv = new ModelAndView("tabelaAdmin");
        Iterable<Cliente> clientes = clienteRepository.findAll();
        mv.addObject("clientes", clientes);
        return mv;
    }

    @RequestMapping(value = "/editarCliente/{id}", method = RequestMethod.GET)
    public ModelAndView editarCliente(@PathVariable("id") long id) {
        Cliente cliente = clienteRepository.findById(id);
        Iterable<Produto> produtos = produtoRepository.findAll();
        ModelAndView mv = new ModelAndView("editarCliente");
        mv.addObject("clientes", cliente);
        mv.addObject("produtos", produtos);
        return mv;
    }

    @RequestMapping(value = "/editarCliente/{id}", method = RequestMethod.POST)
    public String editarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
        return "redirect:/tabelaAdmin";
    }

    @RequestMapping(value = "/deletarCliente/{id}", method = RequestMethod.GET)
    public String deletarCliente(@PathVariable("id") long id) {
        Cliente cliente = clienteRepository.findById(id);
        clienteRepository.delete(cliente);
        return "redirect:/tabelaAdmin";
    }
}