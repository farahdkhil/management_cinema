import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VilleService {

  constructor(private _http: HttpClient) { }

  gouvernaurats = [
    "Jendouba",
    "Tunis",
    "Béja",
    "Ariana",
    "Tozeur",
    "Zaghouan",
    "Bizerte",
    "Tataouine",
    "Gafsa",
    "Tozeur",
    "kébeli",
    "Kef",
    "Siliana",
    "Kairouan",
    "Ben Arous",
    "Gasserine",
    "Sidi bouzid",
    "Sfax",
    "Sousse",
    "Monastir",
    "Mahdia",
    "Nabeul"]
 
}




