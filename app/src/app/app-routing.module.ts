import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListaFornecedorComponent } from './fornecedor/lista-fornecedor/lista-fornecedor.component';
import { CadastroFornecedorComponent } from './fornecedor/cadastro-fornecedor/cadastro-fornecedor.component';

const routes: Routes = [
  { path: 'lista-fornecedor', component: ListaFornecedorComponent },
  { path: 'cadastrar-fornecedor', component: CadastroFornecedorComponent },
  { path: 'alterar-fornecedor', component: CadastroFornecedorComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
