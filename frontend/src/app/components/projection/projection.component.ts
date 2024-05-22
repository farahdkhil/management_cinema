import { Component, OnInit } from '@angular/core';
import { ProjectionService } from '../../service/projection.service';
import { projection } from '../../common/projection';

@Component({
  selector: 'app-projection',
  templateUrl: './projection.component.html',
  styleUrls: ['./projection.component.css']
})
export class ProjectionComponent implements OnInit {

  projections: projection[] = [];
  loading: boolean = true;
  newProjection: projection = {
    dateProjection: new Date(),
    prix: 0,
    salle: { name: '' },
    film: { titre: '' }
  };

  constructor(private projectionService: ProjectionService) { }

  ngOnInit(): void {
    this.getAllProjections();
  }

  getAllProjections(): void {
    this.projectionService.getAllProjections().subscribe(
      (data: projection[]) => {
        this.projections = data;
        this.loading = false;
      },
      error => {
        console.error('Error fetching projections', error);
        this.loading = false;
      }
    );
  }

  deleteProjection(id: number | undefined): void {
    if (id !== undefined) {
      this.projectionService.delete(id).subscribe(
        () => {
          this.projections = this.projections.filter(projection => projection.id !== id);
        },
        error => {
          console.error('Error deleting projection', error);
        }
      );
    }
  }

  addProjection(): void {
    this.projectionService.save(this.newProjection).subscribe(
      (data: projection) => {
        this.projections.push(data);
        this.newProjection = { dateProjection: new Date(), prix: 0, salle: { name: '' }, film: { titre: '' } }; // Reset form
      },
      error => {
        console.error('Error adding projection', error);
      }
    );
  }
}
