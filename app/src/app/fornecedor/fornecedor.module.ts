import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ListaFornecedorComponent } from './lista-fornecedor/lista-fornecedor.component';
import { CadastroFornecedorComponent } from './cadastro-fornecedor/cadastro-fornecedor.component';
import { DetalhesFornecedorComponent } from './detalhes-fornecedor/detalhes-fornecedor.component';
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    ListaFornecedorComponent,
    CadastroFornecedorComponent,
    DetalhesFornecedorComponent
  ],
  imports: [
    CommonModule,
    FormsModule
  ],
  exports: [
    ListaFornecedorComponent,
    CadastroFornecedorComponent,
    DetalhesFornecedorComponent
  ]
})
export class FornecedorModule { }
