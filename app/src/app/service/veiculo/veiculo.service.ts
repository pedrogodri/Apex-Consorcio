import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Endereco } from 'src/app/modelo/endereco/endereco';
import { Veiculo } from 'src/app/modelo/veiculo/veiculo';

@Injectable({
  providedIn: 'root'
})

export class Veiculoserivce {

  constructor(private http: HttpClient) {
 }

  private exemploId: number = 0;
  private url = 'http://localhost:8080/veiculo';

  veiculoExemplo(Veiculo: Veiculo): Observable<Veiculo> {
    return this.http.post<Veiculo>(this.url, Veiculo);
  }

  getVeiculo(): Observable<Veiculo[]> {
    return this.http.get<Veiculo[]>(this.url);
  }

  getExemploById(id: number): Observable<Veiculo>{
    return this.http.get<Veiculo>(`${this.url}/${id}`);
  }

  ataulizarVeiculo(veiculo: Veiculo): Observable<any> {
    return this.http.put<Endereco>(this.url, veiculo);
  }

  deetarVeiculo(veiculo: Veiculo): Observable<any> {
    return this.http.delete<any>(`${this.url}/${this.endereco.id}`)
  }

  getVeiculoId(id: number) {
  this.exemploId = id;
}

setVeiculoId() : number {
  return this.getVeiculoId;
}
}
