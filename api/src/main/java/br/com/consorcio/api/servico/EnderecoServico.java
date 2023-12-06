package br.com.consorcio.api.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.consorcio.api.modelo.Endereco;
import br.com.consorcio.api.modelo.Mensagem;
import br.com.consorcio.api.repositorio.EnderecoRepositorio;


@Service
public class EnderecoServico {
    
    @Autowired
    private Mensagem mensagem;

    @Autowired
    private EnderecoRepositorio enderecoRepositorio;

    public ResponseEntity<?> cadastrarEndereco(Endereco endereco) {

        if(endereco.getBairro().isEmpty() || endereco.getBairro() == null) {
            mensagem.setMensagem("Insira um bairro");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        
        if(endereco.getCidade().isEmpty() || endereco.getCidade() == null) {
            mensagem.setMensagem("Insira uma Cidade");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        
        if(endereco.getEstado().isEmpty() || endereco.getEstado() == null) {
            mensagem.setMensagem("Insira um Estado");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        
        if(endereco.getRua().isEmpty() || endereco.getRua() == null) {
            mensagem.setMensagem("Insira uma Rua");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        
        if(endereco.getComplemento().isEmpty() || endereco.getComplemento() == null) {
            mensagem.setMensagem("Insira um Compemento");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }
        
        if(endereco.getCep() == null ) {
            mensagem.setMensagem("Insira um Cep");
            return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
        }

enderecoRepositorio.save(endereco);
return new ResponseEntity<>(endereco, HttpStatus.CREATED);
    }
}
