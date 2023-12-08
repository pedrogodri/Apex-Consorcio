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
        if (fornecedor.getNome().isEmpty() || fornecedor.getNome() == null) {
            mensagem.setMensagem("Insira um nome.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        if (fornecedor.getCnpj().isEmpty() || fornecedor.getCnpj() == null) {
            mensagem.setMensagem("Insira um cnpj.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }

        if (fornecedor.getTelefone() == null) {
            mensagem.setMensagem("Insira um telefone.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        if(fornecedor.getEmail().isEmpty() || fornecedor.getEmail() == null) {
            mensagem.setMensagem("Insira um Email.");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
            

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

    public ResponseEntity<?> deletarFornecedor(Long id) {
        if (fornecedorRepositorio.existsById((id))) {
            Fornecedor fornecedor = fornecedorRepositorio.findByFornecedorId(id);
            fornecedorRepositorio.delete(fornecedor);
            mensagem.setMensagem("Fornecedor deletado com sucesso");
            return new ResponseEntity<>(mensagem, HttpStatus.OK);

        } else {
            mensagem.setMensagem("Fornecedor encontrado");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);

        }

    }
    
    public ResponseEntity<?> selecionarFornecedorId(long id) {
        if(fornecedorRepositorio.existsById(id)) {
            Fornecedor fornecedorExistente = fornecedorRepositorio.findByFornecedorId(id);
            return new ResponseEntity<>(fornecedorExistente, HttpStatus.OK);
        } else {
            mensagem.setMensagem("Nnenhum fornecedor encontrado");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
        }


        

}

}
