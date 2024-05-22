import { Injectable } from '@angular/core';
import { film } from '../common/film';
import { FilmCategory } from '../common/film-category';
import { HttpClient } from '@angular/common/http';
import { Observable, map } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FilmService{
  
  private baseUrl = 'http://localhost:8000/api/films';
  private categoryUrl = 'http://localhost:8000/api/film-category';

  constructor( private httpClient: HttpClient) { }
  getFilm(theFilmId: number): Observable<film> {

    // need to build URL based on product id
    const filmUrl = `${this.baseUrl}/${theFilmId}`;

    return this.httpClient.get<film>(filmUrl);
  }

  getFilmList(theCategoryId:number):Observable<film[]>{
    // need to build URL based on category id 
    const searchUrl = `${this.baseUrl}/search/findByCategoryId?id=${theCategoryId}`;

    return this.getFilms(searchUrl);

  
  }

  searchFilms(theKeyword: string):Observable<film[]> {
    // need to build URL based on the keyword 
    const searchUrl = `${this.baseUrl}/search/findByNameContainig?name=${theKeyword}`;

    return this.getFilms(searchUrl);
  }

  private getFilms(searchUrl: string): Observable<film[]> {
    return this.httpClient.get<GetResponseFilms>(searchUrl).pipe(
      map(Response => Response._embedded.films)
    );
  }

  getFilmCategories(): Observable<FilmCategory[]>{
    return this.httpClient.get<GetResponseFilmCategory>(this.categoryUrl).pipe(
      map(Response=>Response._embedded.filmCategory)
    );
  }
}

interface GetResponseFilms{
  _embedded: {
    films : film[];
    }
}

interface GetResponseFilmCategory{
  _embedded: {
    filmCategory: FilmCategory[];
    }
}