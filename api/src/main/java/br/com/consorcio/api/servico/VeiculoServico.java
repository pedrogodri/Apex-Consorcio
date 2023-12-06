package br.com.consorcio.api.servico;

import java.sql.Date;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.consorcio.api.modelo.Fornecedor;
import br.com.consorcio.api.modelo.Mensagem;
import br.com.consorcio.api.modelo.Veiculo;
import br.com.consorcio.api.repositorio.FornecedorRepositorio;
import br.com.consorcio.api.repositorio.VeiculoRepositorio;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Service

public class VeiculoServico {

  @Autowired
  private Mensagem mensagem;

  @Autowired
  private VeiculoRepositorio veiculoRepositorio;

  public ResponseEntity<?> cadastrarVeiculo(Veiculo veiculo) {

    if (veiculo.getNome().isEmpty() || veiculo.getNome() == null) {
      mensagem.setMensagem("Insira um Nome");
      return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
    }
    
    if (veiculo.getCor().isEmpty() || veiculo.getCor() == null) {
      mensagem.setMensagem("Insira uma Cor");
      return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);

    } 
    if (veiculo.getAno() == null) {
      mensagem.setMensagem("Insira o Ano do seu carro");
      return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
    } 
    if (veiculo.getKmRodado() == null) {
      mensagem.setMensagem("Insira quantos kmRodado");
      return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
    } 
    if (veiculo.getPreco() == null) {
      mensagem.setMensagem("Insira um Preco");
      return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
    } 
    if (veiculo.getDescricao().isEmpty() || veiculo.getDescricao() == null) {
      mensagem.setMensagem("Insira uma Descricao");
      return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
    }


    veiculoRepositorio.save(veiculo);
    return new ResponseEntity<>(veiculo, HttpStatus.CREATED);

  }

    // public List<Veiculo>listarVeiculo() {
    //      return veiculoRepositorio.findAll();
    // }
// }
//   public ResponseEntity<?> alterarVeicuo(Veiculo veiculo) {
    
//   }
  
  
// }
}