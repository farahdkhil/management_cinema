import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { cinema } from '../common/cinema';
import { ville } from '../common/ville';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CinemaService {

  url = `http://localhost:8000/cinemas`;
  constructor(public http: HttpClient) { }

  saveCinema(c: cinema) {
    const myCinema = {
      name: c.name,
      countSalles: c.countSalles,
      //ville: `http://localhost:8080/villes/${c.ville.id}`
    }
    return this.http.post(this.url, myCinema);
  }

  findCinemasByVilleId(id:any) {
    // let url = 'http://localhost:8080/cinemas/search/findByVilleId?id=1';
    return this.http.get<onGetResponseCinemas>(`${this.url}/search/findByVilleId?id=${id}`)
        .pipe(
          map( response=> response._embedded.cinemas)
        );
  }

  deleteCinema(id:any, ville:ville) {
    const urlForDeleteCinema = `http://localhost:8000/deleteCinemas/${id}/${ville.id}`;
    return this.http.delete(`${urlForDeleteCinema}`);
  }


  findCinemaById(id:any) {
    return this.http.get<cinema>(`${this.url}/${id}`);
  }
}

interface onGetResponseCinemas {
  _embedded: {
    cinemas: cinema[]
  }
}