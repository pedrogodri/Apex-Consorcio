package br.com.consorcio.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.consorcio.api.modelo.Cliente;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long>{
    
    @Query("SELECT cliente FROM Cliente cliente WHERE cliente.id = :id")
    Cliente findByClienteId(Long id);
}
