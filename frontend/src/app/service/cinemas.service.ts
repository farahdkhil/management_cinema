import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { cinema } from '../common/cinema';
import { ville } from '../common/ville';
import { salle } from '../common/salle';
import { place } from '../common/place';
@Injectable({
  providedIn: 'root'
})
export class CinemasService {

  host: string = 'http://localhost:8080/';
  constructor(public http: HttpClient) { }


  getAllCities() {
    return this.http.get(`${this.host}villes`);
  }
  getCinemas(ville:ville) {
   // return this.http.get(ville._links.cinemas.href);
  }
  getRooms(cinema:cinema) {
    //return this.http.get(cinema._links.rooms.href);
  }
  getProjections(salle:salle) {
    //let url = salle._links.projectionMovies.href.replace('{?projection}', '');
   // return this.http.get(url+'?projection=p1');
  }
  getTicketsPlaces(p:place) {
    //let url = p._links.tickets.href.replace('{?projection}', '');
    //return this.http.get(url+'?projection=ticketProj');
  }

  buyTickets(f: any) {
    const url = `${this.host}/buyTickets`
    return this.http.post(url, f);
  }
}