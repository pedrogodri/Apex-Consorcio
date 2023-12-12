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
}
