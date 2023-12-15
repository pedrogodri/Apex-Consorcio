import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Fornecedor } from 'src/app/modelo/fornecedor/fornecedor';
import { FornecedorService } from 'src/app/service/fornecedor/fornecedor.service';

@Component({
  selector: 'app-lista-fornecedor',
  templateUrl: './lista-fornecedor.component.html',
  styleUrls: ['./lista-fornecedor.component.css']
})
export class ListaFornecedorComponent implements OnInit {
  
  fornecedores: Fornecedor[] = [];
  fornecedorSelecionada: Fornecedor = new Fornecedor();
  fornecedorExiste: boolean = false;

  constructor(private service: FornecedorService, private rota: Router) {}


  ngOnInit(): void {
    this.service.getFornecedores().subscribe(
      (      resposta: Fornecedor[]) => {
        this.fornecedores = resposta;
      }
    )

  }

  novoFornecedor(): void {
    this.service.setFornecedorId(0);
    this.rota.navigate(['cadastrar-fornecedor']);
  }

  editarFornecedor(id: number):void {
    this.service.setFornecedorId(id);
    this.rota.navigate(['alterar-fornecedor'])
  }

  deletarFornecedor(fornecedor: Fornecedor) {
    this.fornecedorSelecionada = fornecedor;
    this.service.deletarFornecedor(this.fornecedorSelecionada).subscribe(
      (      resposta: any) => {
        this.ngOnInit();
      },
      erro => {
        console.log(erro)
      }
    )
  }

}
