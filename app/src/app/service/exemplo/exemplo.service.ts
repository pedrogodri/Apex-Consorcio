import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Endereco } from 'src/app/modelo/endereco/endereco';

@Injectable({
  providedIn: 'root'
})
export class ExemploService {

  constructor(private http: HttpClient) { }

  private exemploId: number = 0;
  private url = 'http://localhost:8080/endereco';

  cadastrarExemplo(endereco: Endereco): Observable<Endereco> {
    return this.http.post<Endereco>(this.url, endereco);
  }

  getExemplo(): Observable<Endereco[]> {
    return this.http.get<Endereco[]>(this.url);
  }

  getExemploById(id: number): Observable<Endereco> {
    return this.http.get<Endereco>(`${this.url}/${id}`);
  }

  atualizarExemplo(endereco: Endereco): Observable<any> {
    return this.http.put<Endereco>(this.url, endereco);
  }

  deletarExemplo(endereco: Endereco): Observable<any> {
    return this.http.delete<any>(`${this.url}/${endereco.id}`);
  }

  getExemploId(id: number) {
    this.exemploId = id;
  }

  setExemploId() : number {
    return this.exemploId;
  }
}
