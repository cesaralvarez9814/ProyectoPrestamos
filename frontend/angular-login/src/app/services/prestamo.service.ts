import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, retry, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PrestamosService {

  constructor(private http:HttpClient) { }

  getPrestamos():Observable<any>{
    return this.http.get(environment.urlApi+"prestamos").pipe(
      catchError(this.handleError)
    )
  }
  getClientes():Observable<any>{
    return this.http.get(environment.urlApi+"clientes").pipe(
      catchError(this.handleError)
    )
  }
  getMontos():Observable<any>{
    return this.http.get(environment.urlApi+"montos").pipe(
      catchError(this.handleError)
    )
  }
  getPlazos():Observable<any>{
    return this.http.get(environment.urlApi+"plazos").pipe(
      catchError(this.handleError)
    )
  }
  public guardar(data: any): Observable<any> {
    const body =  JSON.stringify(data);
    const headers = { 'Content-Type': 'application/json' };
    return this.http.post<any>(environment.urlApi + 'prestamos', body, { headers });
  }
  public getTabla(id:number):Observable<any>{
    return this.http.get(`${environment.urlApi + 'prestamos/tabla'}/${id} `).pipe(
      catchError(this.handleError)
    )
  }


  private handleError(error:HttpErrorResponse){
    if(error.status===0){
      console.error('Se ha producio un error ', error.error);
    }
    else{
      console.error('Backend retornó el código de estado ', error.status, error.error);
    }
    return throwError(()=> new Error('Algo falló. Por favor intente nuevamente.'));
  }
}
