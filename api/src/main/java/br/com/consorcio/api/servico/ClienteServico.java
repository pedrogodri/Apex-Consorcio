package br.com.consorcio.api.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.consorcio.api.modelo.Cliente;
import br.com.consorcio.api.modelo.Mensagem;
import br.com.consorcio.api.repositorio.ClienteRepositorio;

@Service
public class ClienteServico {
    
    private Mensagem mensagem;

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public ResponseEntity<?> cadastrarCliente(Cliente cliente) {
        
        //nome
        if(cliente.getNome().isEmpty() || cliente.getNome() == null) {
            mensagem.setMensagem("Insira um nome.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        //sobrenome
        if (cliente.getSobrenome().isEmpty() || cliente.getSobrenome() == null) {
            mensagem.setMensagem("Insira um sobrenome.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        //email
        if (cliente.getEmail().isEmpty() || cliente.getEmail() == null) {
            mensagem.setMensagem("Insira um email.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        //senha
        if (cliente.getSenha().isEmpty() || cliente.getSenha() == null) {
            mensagem.setMensagem("Insira uma senha.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        //cpf
        if (cliente.getCpf().isEmpty() || cliente.getCpf() == null) {
            mensagem.setMensagem("Insira um cpf.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        //idade
        if (cliente.getIdade() < 18){
            mensagem.setMensagem("Insira uma idade valida.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        //endereco
        if (cliente.getEndereco() == null) {
            mensagem.setMensagem("Insira um Endereço valido.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        //telefone
        if (cliente.getTelefone() == null){
            mensagem.setMensagem("Insira o seu número de telefone.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        //sucesso
        clienteRepositorio.save(cliente);
        return new ResponseEntity<>(cliente, HttpStatus.CREATED);
    }

    public List<Cliente> listarClientes(){
        return clienteRepositorio.findAll();
    }

    // public ResponseEntity<?> alterarCliente(Cliente cliente) {
    //     if(cliente.getId() == null) {
    //         mensagem.setMensagem("Id do cliente não foi informado.");
    //     }
    //     if(clienteRepositorio.existsById(cliente.getId())) {
    //         Cliente clienteExistente = clienteRepositorio.findByClienteId(cliente.getId());
    //     }
    // }
}
