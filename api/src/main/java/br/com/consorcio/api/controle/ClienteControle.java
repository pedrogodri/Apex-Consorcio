package br.com.consorcio.api.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.consorcio.api.modelo.Cliente;
import br.com.consorcio.api.servico.ClienteServico;

@CrossOrigin("*")
@RestController
@RequestMapping("/cliente")
public class ClienteControle {
    
    @Autowired
    private ClienteServico clienteServico;

    //Cadastrar
    @PostMapping()
    public ResponseEntity<?> cadastrarCliente(@RequestBody Cliente cliente) {
        return clienteServico.cadastrarCliente(cliente);
    }

    //listar
    @GetMapping()
    public List<Cliente> listarClientes() {
        return clienteServico.listarClientes();
    }

    //listar por id
    @GetMapping("/{id}")
    public ResponseEntity<?> selecionarClienteId(@PathVariable Long id){
        return clienteServico.selecionarClienteId(id);
    }

    //alterar
    @PutMapping()
    public ResponseEntity<?> alterarCliente(@RequestBody Cliente cliente) {
        return clienteServico.alterarCliente(cliente);
    }

    //deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarCliente(@PathVariable Long id){
        return clienteServico.deletarCliente(id);
    }
}
