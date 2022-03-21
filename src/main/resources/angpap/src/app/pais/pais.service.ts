import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, Observable, throwError } from 'rxjs';
import { Pais } from './pais';

@Injectable({
  providedIn: 'root'
})


export class PaisService {

  private apiURL = 'http://localhost:8080';

  httpOptions = {
    headers: new HttpHeaders()
    .set('Content-Type', 'application/json')
    .set('Access-Control-Allow-Origin', '*')
  }

  constructor(private httpClient: HttpClient) { }

  getAll(): Observable<any> {
    return this.httpClient
    .get(this.apiURL + '/paises/',this.httpOptions)
//    .get(this.apiURL + '/REST/pais/r',this.httpOptions)
    .pipe(
        catchError(this.errorHandler)
      )
  }

  create(pais: Pais): Observable<any> {
    return this.httpClient
      .post(this.apiURL + '/paises/', JSON.stringify(pais), this.httpOptions)
      .pipe(
        catchError(this.errorHandler)
      )
  }

  find(id: number): Observable<any> {
    return this
      .httpClient
      .get(this.apiURL + '/paises/' + id)
      .pipe(
        catchError(this.errorHandler)
      )
  }

  update(id: number, pais: Pais): Observable<any> {

    return this.httpClient
      .put(
        this.apiURL + '/paises/' + id, JSON.stringify(pais),
        this.httpOptions)
      .pipe(
        catchError(this.errorHandler)
      )
  }

  delete(id: number) {
    return this.httpClient
      .delete(
        this.apiURL + '/paises/' + id,
        this.httpOptions)
      .pipe(
        catchError(this.errorHandler)
      )
  }

  errorHandler(error: any) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      errorMessage = error.error.message;
    }
    else {
      errorMessage = `Error Code: ${error.status}|nMessage: ${error.message}`;
    }
    return throwError(errorMessage);
  }
}
