import { Component ,OnInit} from '@angular/core';
import { film } from '../../common/film';
import { FilmService1 } from '../../service/films1.service';
@Component({
  selector: 'app-search-film',
  templateUrl: './search-film.component.html',
  styleUrl: './search-film.component.css'
})
export class SearchFilmComponent  implements OnInit{
  films : film[] = [];
  loading : boolean = true;
  keyword: string = '';
  constructor(private _film: FilmService1) { }

  ngOnInit(): void {

      this.handleSearchFilm();
  
  }
  setKeyword(keyword: string): void {
    this.keyword = keyword;
    this.handleSearchFilm();
  }

  handleSearchFilm() {
    
    if (this.keyword) {
      this._film.getFilmByName(this.keyword).subscribe(
        (data: film[]) => {
          this.loading = false;
          this.films = data;
        }
      );
    }
  }
}
