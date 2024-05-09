import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CinemaComponent } from './components/cinema/cinema.component';
import { CinemasComponent } from './components/cinemas/cinemas.component';
import { CinemaDetailComponent } from './components/cinema-detail/cinema-detail.component';
import { VilleComponent } from './components/ville/ville.component';
import { SalleComponent } from './components/salle/salle.component';
import { FilmComponent } from './components/film/film.component';
import { CategorieComponent } from './components/categorie/categorie.component';
import { MesReservationsComponent } from './components/mes-reservations/mes-reservations.component';
const routes: Routes = [
  {path: 'cinema', component: CinemaComponent  },
  {path: 'cinemas', component: CinemasComponent  },
  {path: 'cinema-detail', component: CinemaDetailComponent  },
  {path: 'ville', component: VilleComponent  },
  {path: 'salle', component: SalleComponent  },
  {path: 'film', component: FilmComponent  },
  {path: 'categorie', component: CategorieComponent  },
  {path: 'reservations', component: MesReservationsComponent  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
