import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../environments/environment';
import { salle } from '../common/salle';


@Injectable({
  providedIn: 'root'
})
export class SalleService {


  baseUrl = environment.baseUrl;


  public getHeader(): HttpHeaders {
    let requestHeader = new HttpHeaders();
    //requestHeader = requestHeader.append("Authorization","Bearer "+ sessionStorage.getItem('JwtToken'));
    requestHeader = requestHeader.append("Access-Control-Allow-Origin", "*");
    return requestHeader;
  }

  constructor(private _http: HttpClient) { }

  /* specialities$ = this._http.get<Salle[]>(this.baseUrl + "salle/find-all"); */

  getAllSalles(): Observable<salle[]> {
    return this._http.get<salle[]>(this.baseUrl + "salle/find-all");
  }

  delete(id: number) {
    return this._http.delete(this.baseUrl + `salle/${id}`);
  }

  save(salle: salle) {
    return this._http.post<salle>(this.baseUrl + "salle/add", salle);

  }

  getSalleDataById(id: any) {
    return this._http.get<salle>(this.baseUrl + `salle/find-by-id/${id}`)
  }


}