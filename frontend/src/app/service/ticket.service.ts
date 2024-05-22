import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ticket } from '../common/ticket';
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class TicketService {

  constructor(private _http: HttpClient) { }

  baseUrl = environment.baseUrl;

  findAll() {
    return this._http.get<ticket[]>(this.baseUrl + "ticket/find-all");
  }

  delete(id: any) {
    return this._http.delete(this.baseUrl + `ticket/${id}`);
  }
  findByUserId(id: any) {
    return this._http.get<ticket[]>(this.baseUrl + `ticket/find-by-user-id/${id}`);
  }
  
  annulerRes(id:any){
    return this._http.delete(this.baseUrl + `ticket/${id}`);
  }

  save(ticket: any) {
    return this._http.post(this.baseUrl + "ticket/add", ticket)
  }
}