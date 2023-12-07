package br.com.consorcio.api.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.consorcio.api.modelo.Fornecedor;
import br.com.consorcio.api.servico.FornecedorServico;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/fornecedor")
public class FornecedorControle {
  
@Autowired
private FornecedorServico fornecedorServico;

//Cadastrar
@PostMapping()
public ResponseEntity<?> cadastrarFornecedor(@RequestBody Fornecedor fornecedor) {
  return fornecedorServico.cadastrarFornecedor(fornecedor);
}

@GetMapping()
public List<Fornecedor> listarFornecedor() {
  return fornecedorServico.listarfornecedor();
}

//Editar
@PutMapping()
public ResponseEntity<?> alterarFornecedor(@RequestBody Fornecedor fornecedor) {
  return fornecedorServico.alterarFornecedor(fornecedor);
}

}



