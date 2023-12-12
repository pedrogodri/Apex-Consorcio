package br.com.consorcio.api.servico;

// Importações corretas
import java.util.List;
import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.consorcio.api.modelo.Mensagem;
import br.com.consorcio.api.modelo.Veiculo;
import br.com.consorcio.api.repositorio.VeiculoRepositorio;

@Service
public class VeiculoServico {

  @Autowired
  private Mensagem mensagem;

  @Autowired
  private VeiculoRepositorio veiculoRepositorio;

  public ResponseEntity<?> cadastrarVeiculo(Veiculo veiculo) {
    // Verificações corrigidas
    if (veiculo.getNome() == null || veiculo.getNome().isEmpty()) {
      mensagem.setMensagem("Insira um Nome");
      return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
    }
    // Repita a estrutura acima para as outras verificações...

    veiculoRepositorio.save(veiculo);
    return new ResponseEntity<>(veiculo, HttpStatus.CREATED);
  }

  public List<Veiculo> listarVeiculo() {
    return veiculoRepositorio.findAll();
  }

  public ResponseEntity<?> alterarVeiculo(Veiculo veiculo) {
    if (veiculo.getId() == null) {
      mensagem.setMensagem("ID do veículo não foi informado");
      return new ResponseEntity<>(mensagem, HttpStatus.BAD_REQUEST);
    }
    if (veiculoRepositorio.existsById(veiculo.getId())) {
      Veiculo veiculoExistente = veiculoRepositorio.findByVeiculoId(veiculo.getId());
      veiculoExistente.setAno(veiculo.getAno());
      // Atualize as outras propriedades conforme necessário...

      veiculoRepositorio.save(veiculoExistente);
      return new ResponseEntity<>(veiculoExistente, HttpStatus.CREATED);
    } else {
      mensagem.setMensagem("Veículo não encontrado!");
      return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
    }

  }
/* 
   public static ResponseEntity<?> deletarVeiculo(Long id) {
    if(VeiculoRepositorio.existsById(id)) {
 Veiculo veiculo =  VeiculoRepositorio.findByVeiculoId(id);
 mensagem.setMensagem("veiculo Deletado com sucesso");
 veiculoRepositorio.delete(veiculo);
 return new ResponseEntity<>(mensagem, HttpStatus.OK);

   } else {
    mensagem.setMensagem("Nnenhum Veiculo encontrado");
    return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
              }   
         
        }

        public ResponseEntity<?> listarVeiculo(Long id) {
          if(veiculoRepositorio.existsById(id)) {
            Veiculo veiculoExistente = veiculoRepositorio.findByVeiculoId(id);
            return new ResponseEntity<>(veiculoExistente, HttpStatus.OK);
          } else {
            mensagem.setMensagem("Nenhum veiculo encontrado");
            return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);          

          }
        }
  

  } */

  public ResponseEntity<?> deletarVeiculo(Long id) {
    if (veiculoRepositorio.existsById(id)) {
      Veiculo veiculo = veiculoRepositorio.findByVeiculoId(id);
      mensagem.setMensagem("veiculo Deletado com sucesso");
      veiculoRepositorio.delete(veiculo);
      return new ResponseEntity<>(mensagem, HttpStatus.OK);

    } else {
      mensagem.setMensagem("Nnenhum Veiculo encontrado");
      return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);
    }

  }

  public ResponseEntity<?> selecionarVeiculoId(Long id) {
    if (veiculoRepositorio.existsById(id)) {
      Veiculo veiculoExistente = veiculoRepositorio.findByVeiculoId(id);
      return new ResponseEntity<>(veiculoExistente, HttpStatus.OK);
    } else {
      mensagem.setMensagem("Nenhum veiculo encontrado");
      return new ResponseEntity<>(mensagem, HttpStatus.NOT_FOUND);

    }
  }

}
