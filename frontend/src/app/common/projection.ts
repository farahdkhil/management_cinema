import { salle } from "./salle";
import { film } from "./film";
export class projection {
    id?: number;
    dateProjection? : Date;
    prix?: number;
    salle? : salle;
    film? : film
  }