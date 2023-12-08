package br.com.consorcio.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.consorcio.api.modelo.Cliente;
import br.com.consorcio.api.modelo.Fornecedor;

@Repository
public interface FornecedorRepositorio extends JpaRepository<Fornecedor, Long> {
    @Query("SELECT fornecedor FROM Fornecedor fornecedor WHERE fornecedor.id = :id")
    Fornecedor findByFornecedorId(Long id);
}
