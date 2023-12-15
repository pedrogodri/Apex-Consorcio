import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Fornecedor } from 'src/app/modelo/fornecedor/fornecedor';
@Injectable({
  providedIn: 'root'
})
export class FornecedorService {

  constructor(private http: HttpClient) { }
  private fornecedorId: number = 0;
  private url = 'http://localhost:8080/fornecedor';
  cadastrarFornecedor(fornecedor: Fornecedor): Observable<Fornecedor> {
    return this.http.post<Fornecedor>(this.url, fornecedor);
  }

  getFornecedores(): Observable<Fornecedor[]> {
    return this.http.get<Fornecedor[]>(this.url) 
  }
  
  getFornecedorById(id: number): Observable<Fornecedor> {
    return this.http.get<Fornecedor>(`${this.url}/${id}`)
  }

  atualizarFornecedor(fornecedor: Fornecedor): Observable<any> {
    return this.http.put<Fornecedor>(this.url, fornecedor);
}

  deletarFornecedor(fornecedor: Fornecedor): Observable<any> {
    return this.http.delete<any>(`${this.url}/${fornecedor.id}`);
}
  

setFornecedorId(id: number) {
  this.fornecedorId = id;
}
getFornecedorId() : number {
  return this.fornecedorId;
}

}
