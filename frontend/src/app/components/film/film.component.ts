import { Component, OnInit } from '@angular/core';
import { FilmService1 } from '../../service/films1.service';
import { FilmService } from '../../service/film.service';
import { film } from '../../common/film';
import { FilmCategory } from '../../common/film-category';

@Component({
  selector: 'app-film',
  templateUrl: './film.component.html',
  styleUrls: ['./film.component.css']
})
export class FilmComponent implements OnInit {
  films : film[] = [];
  currentCategoryId:number=1;
  searchMode:boolean=false;
  loading : boolean = true;
  
  constructor(private filmService : FilmService, private _film: FilmService1){}


  ngOnInit(){
      this.listFilms();


    this._film.getAllFilms().subscribe(
      (data:  film[]) => {
        this.loading = false;
        this.films = data;
      }
    )
  }

 

  listFilms() {
    this.searchMode = false; // Assume no search mode for now
    this.currentCategoryId = 1; // Default category ID
    if (this.searchMode){
      this.handleListFilms();
    }
    else {
    this.handleListFilms();
    }

  }

  handleSearchFilms(){
     
    
    const theKeyword: string = '';
    //now search for the films using keywoed 
    this.filmService.searchFilms(theKeyword).subscribe(
      data => {
        this.films = data;
      }
    )

  }

  handleListFilms() {
    // Without `route`, we'll assume `currentCategoryId` is set directly.
    // Now get the films for the given category id
    this.filmService.getFilmList(this.currentCategoryId).subscribe(
      data => {
        this.films = data;
      }
    );
  }
}