import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cliente } from 'src/app/modelo/cliente/cliente';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  constructor(private http: HttpClient) { }

  private clienteId: number = 0;
  private url = 'http://localhost:8080/cliente';

  cadastrarCliente(cliente: Cliente): Observable<Cliente> {
    return this.http.post<Cliente>(this.url, cliente);
  }

  getCliente(): Observable<Cliente[]> {
    return this.http.get<Cliente[]>(this.url);
  }

  atualizarCliente(cliente: Cliente): Observable<any> {
    return this.http.put<Cliente>(this.url, cliente);
  }

  deletarCliente(cliente: Cliente): Observable<any> {
    return this.http.delete<any>(`${this.url}/${cliente.id}`)
  }

  getExemploById(id: number): Observable<Cliente> {
    return this.http.get<Cliente>(`${this.url}/${id}`)
  }

  getClienteId(id: number) {
    this.clienteId = id;
  }

  setClienteId(): number {
    return this.clienteId;
  }
}
