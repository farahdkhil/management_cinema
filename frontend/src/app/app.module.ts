import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { CinemaComponent } from './components/cinema/cinema.component';
import { HttpClientModule } from '@angular/common/http';
import { CinemasComponent } from './components/cinemas/cinemas.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    CinemaComponent,
    CinemasComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
