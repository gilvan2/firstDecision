import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {
  private apiUrl = 'http://localhost:8989/cliente/registrar';

  constructor(private http: HttpClient) { }

  registrarCliente(cliente: any): Observable<any> {
    console.log(cliente)
    return this.http.post<any>(this.apiUrl, cliente);
  }
}
