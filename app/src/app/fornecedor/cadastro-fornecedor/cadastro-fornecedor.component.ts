import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Fornecedor } from 'src/app/modelo/fornecedor/fornecedor';
import { FornecedorService } from 'src/app/service/fornecedor/fornecedor.service';

@Component({
  selector: 'app-cadastro-fornecedor',
  templateUrl: './cadastro-fornecedor.component.html',
  styleUrls: ['./cadastro-fornecedor.component.css']
})
export class CadastroFornecedorComponent implements OnInit {

  fornecedor: Fornecedor = new Fornecedor;
  id?: number;

  constructor(private service: FornecedorService, private rota: Router) {}


  ngOnInit(): void {
    this.id = this.service.getFornecedorId();
    if(this.id) {
      this.service.getFornecedorById(this.id).subscribe(
        (        resposta: Fornecedor) => {
          this.fornecedor = resposta;
        },
        erro => {
          this.fornecedor = new Fornecedor()
        }
      )
    }
  }

  onSubmit(): void {
    if(this.id) {
      this.service.atualizarFornecedor(this.fornecedor).subscribe(
        //Mensagem

      )
    } else {
      this.service.cadastrarFornecedor(this.fornecedor).subscribe(
        (        //Mensagem
        resposta: any) => {
          console.log(resposta);
        },
        erro => {
          console.log(erro)
        }
      )
    }
  }

  voltarListagem(): void {
    this.rota.navigate(['lista-fornecedor']);
  }

}
