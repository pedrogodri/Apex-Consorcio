package br.com.consorcio.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.consorcio.api.modelo.Endereco;

@Repository
public interface EnderecoRepositorio extends JpaRepository<Endereco, Integer> {
    
}
