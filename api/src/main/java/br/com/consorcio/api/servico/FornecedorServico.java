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

  public ResponseEntity<?> cadastrarFornecedor(Fornecedor fornecedor) {
    
    if (fornecedor.getNome().isEmpty() || fornecedor.getNome() == null) {
      mensagem.setMensagem("Insira um nome");
      return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
    }
    
    if (fornecedor.getCnpj().isEmpty() || fornecedor.getNome() == null) {
      mensagem.setMensagem("Insira um cnpj");
      return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
    }

    if (fornecedor.getEmail().isEmpty() || fornecedor.getNome() == null) {
      mensagem.setMensagem("Insira um Email");
      return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
    }
    
    if (fornecedor.getTelefone() == null) {
      mensagem.setMensagem("Insira um Telefone");
      return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
    }
    
    


    fornecedorRepositorio.save(fornecedor);
    return new ResponseEntity<>(fornecedor, HttpStatus.CREATED);

  }
  
  public List<Fornecedor> listarfornecedor() {
    return fornecedorRepositorio.findAll();

  }

  
  public ResponseEntity<?> alterarFornecedor(Fornecedor fornecedor) {
    if (fornecedor.getId() == null) {
      mensagem.setMensagem("Id do Fornecedor não foi informado");
    }
    if (fornecedorRepositorio.existsById(fornecedor.getId())) {


      Fornecedor fornecedorExistente = fornecedorRepositorio.findByFornecedorId(fornecedor.getId());

      fornecedorExistente.setNome(fornecedor.getNome());
      fornecedorExistente.setCnpj(fornecedor.getCnpj());
      fornecedorExistente.setTelefone(fornecedor.getTelefone());
      fornecedorExistente.setEmail(fornecedor.getEmail());

      fornecedorRepositorio.save(fornecedorExistente);
      return new ResponseEntity<>(fornecedorExistente, HttpStatus.CREATED);
    } else {
      mensagem.setMensagem("Fornecedor não encontrado");
      return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
      }
  }
    
}


