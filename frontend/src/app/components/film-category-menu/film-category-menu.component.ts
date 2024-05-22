import { Component } from '@angular/core';
import { FilmCategory } from '../../common/film-category';
import { CategoryService } from '../../service/category.service';
import { FilmService } from '../../service/film.service';
@Component({
  selector: 'app-film-category-menu',
  templateUrl: './film-category-menu.component.html',
  styleUrl: './film-category-menu.component.css'
})
export class FilmCategoryMenuComponent {
  filmCategories: FilmCategory[] | undefined;
  constructor(private filmService: FilmService , private _category: CategoryService){}

  loading : boolean = true;
  categories: FilmCategory[] = [];
  
  ngOnInit(): void {
    this.listFilmCategories();

    this._category.getAllCategory().subscribe(
      (data: FilmCategory[]) => {
        this.loading = false;
        this.categories = data;
      }
    )
  }
  
  listFilmCategories(){
  
      this.filmService.getFilmCategories().subscribe(
        data => {
          console.log('Film  Categories ='+ JSON.stringify(data));
          this.filmCategories= data
        }
      );
    }
}
