import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../environments/environment';
import { projection } from '../common/projection';
import { Observable } from 'rxjs';
import { film } from '../common/film';

@Injectable({
  providedIn: 'root'
})
export class ProjectionService {

  baseUrl = environment.baseUrl;

  public getHeader(): HttpHeaders {
    let requestHeader = new HttpHeaders();
    //requestHeader = requestHeader.append("Authorization","Bearer "+ sessionStorage.getItem('JwtToken'));
    requestHeader = requestHeader.append("Access-Control-Allow-Origin", "*");
    return requestHeader;
  }

  constructor(private _http: HttpClient) { }

  getAllProjections(): Observable<projection[]> {
    return this._http.get<projection[]>(this.baseUrl + "projection/find-all");
  }

  getAllByFilm(film: number): Observable<projection[]> {
    return this._http.get<projection[]>(this.baseUrl + `projection/find-by-film/${film}`);
  }

  delete(id: number) {
    return this._http.delete(this.baseUrl + `projection/${id}`);
  }

  save(projection: projection) {
    return this._http.post<projection>(this.baseUrl + "projection/add", projection);

  }
}