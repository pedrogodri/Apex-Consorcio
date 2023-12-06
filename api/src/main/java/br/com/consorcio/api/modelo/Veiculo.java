package br.com.consorcio.api.modelo;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "veiculo")


public class Veiculo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
   // private byte img;
    private String nome;
    private String cor;
    private Integer ano;
    private Double kmRodado;
    private Fornecedor fornecedor;
    private Double preco;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cliente")
    private String descricao;


}
