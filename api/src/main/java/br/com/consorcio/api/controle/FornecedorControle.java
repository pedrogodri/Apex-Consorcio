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

import br.com.consorcio.api.modelo.Fornecedor;
import br.com.consorcio.api.servico.FornecedorServico;

@RestController
@CrossOrigin
@RequestMapping("/fornecedor")
public class FornecedorControle {
    
    @Autowired
    private FornecedorServico fornecedorServico;

    @GetMapping()
    public List<Fornecedor> listarFornecedores() {
        return fornecedorServico.listarFornecedor();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> selecionarFornecedorId(@PathVariable Long id) {
        return fornecedorServico.selecionarFornecedorId(id);
    }

    @PostMapping()
    public ResponseEntity<?> cadastrarFornecedor(@RequestBody Fornecedor fornecedor) {
        return fornecedorServico.cadastrarFornecedor(fornecedor);
    }

    @PutMapping()
    public ResponseEntity<?> alterarFornecedor(@RequestBody Fornecedor fornecedor) {
        return fornecedorServico.alterarFornecedor(fornecedor);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarFornecedor(@PathVariable Long id) {
        return fornecedorServico.deletarFornecedor(id);
    }

    


}
