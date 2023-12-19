package br.com.consorcio.api.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import br.com.consorcio.api.modelo.Fornecedor;
import br.com.consorcio.api.modelo.Cliente;


@Getter
@Setter
@Entity
@Table(name = "veiculo")
public class Veiculo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nome;
    private String cor;
    private Integer ano;
    private Double kmRodado;
    private Double preco;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;
}
