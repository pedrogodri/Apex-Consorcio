package br.com.consorcio.api.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.consorcio.api.modelo.Veiculo;
import br.com.consorcio.api.servico.VeiculoServico;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/veiculo")
public class VeiculoControle {
  
@Autowired
private VeiculoServico veiculoServico;

//Cadastrar
@PostMapping()
public ResponseEntity<?> cadastrarVeiculo(@RequestBody Veiculo veiculo) {
  return veiculoServico.cadastrarVeiculo(veiculo);
}

@GetMapping()
public List<Veiculo> listarFornecedor() {
  return veiculoServico.listarVeiculo();
}
// ediatar
@PutMapping()
public ResponseEntity<?> alterarVeiculo(@RequestBody Veiculo veiculo) {
    //TODO: process PUT request
    
    return veiculoServico.alterarVeiculo(veiculo);
}
}



