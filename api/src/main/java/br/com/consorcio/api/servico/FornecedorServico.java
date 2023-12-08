package br.com.consorcio.api.servico;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.consorcio.api.modelo.Fornecedor;
import br.com.consorcio.api.modelo.Mensagem;
import br.com.consorcio.api.repositorio.FornecedorRepositorio;

@Service
public class FornecedorServico {
    
    @Autowired
    private Mensagem mensagem;

    @Autowired
    private FornecedorRepositorio fornecedorRepositorio;

    //cadastrar
    public ResponseEntity<?> cadastrarFornecedor(Fornecedor fornecedor) {
        //sucesso
        fornecedorRepositorio.save(fornecedor);
        return new ResponseEntity<>(fornecedor, HttpStatus.CREATED);
    }

    //listar
    public List<Fornecedor> listarFornecedor(){
        return fornecedorRepositorio.findAll();
    }

    //alterar
    public ResponseEntity<?> alterarFornecedor(Fornecedor fornecedor) {
        if(fornecedor.getId() == null) {
            mensagem.setMensagem("Id do fornecedor não foi informado.");
        }
        if(fornecedorRepositorio.existsById(fornecedor.getId())) {
            Fornecedor fornecedorExistente = fornecedorRepositorio.findByFornecedorId(fornecedor.getId());
            fornecedorExistente.setNome(fornecedor.getNome());
            fornecedorExistente.setCnpj(fornecedor.getCnpj());
            fornecedorExistente.setEmail(fornecedor.getEmail());
            fornecedorExistente.setTelefone(fornecedor.getTelefone());

            fornecedorRepositorio.save(fornecedorExistente);

            return new ResponseEntity<>(fornecedorExistente, HttpStatus.CREATED);
        } else {
            mensagem.setMensagem("Fornecedor nao encontrado!");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }
    }

    
}
