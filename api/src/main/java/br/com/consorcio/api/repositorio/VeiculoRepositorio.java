package br.com.consorcio.api.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.consorcio.api.modelo.Veiculo;
import java.util.List;


@Repository


public interface VeiculoRepositorio extends JpaRepository<Veiculo, Long> {


    @Query("SELECT Veiculo FROM veiculo veiculo where veiculo.id = :id")
  Veiculo findByVeicuoId(long id);
}
