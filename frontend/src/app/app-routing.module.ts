import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CinemaComponent } from './components/cinema/cinema.component';
import { CinemasComponent } from './components/cinemas/cinemas.component';
import { CinemaDetailComponent } from './components/cinema-detail/cinema-detail.component';
import { VilleComponent } from './components/ville/ville.component';
import { SalleComponent } from './components/salle/salle.component';
const routes: Routes = [
  {path: 'cinema', component: CinemaComponent  },
  {path: 'cinemas', component: CinemasComponent  },
  {path: 'cinema-detail', component: CinemaDetailComponent  },
  {path: 'ville', component: VilleComponent  },
  {path: 'salle', component: SalleComponent  },
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
