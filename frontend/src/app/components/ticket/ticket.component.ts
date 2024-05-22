import { Component, OnInit } from '@angular/core';
import { TicketService } from '../../service/ticket.service';
import { ticket } from '../../common/ticket';

@Component({
  selector: 'app-ticket',
  templateUrl: './ticket.component.html',
  styleUrls: ['./ticket.component.css']
})
export class TicketComponent implements OnInit {

  tickets: ticket[] = [];
  loading: boolean = true;
  newTicket: ticket = {
    nomclient: '',
    prix: 0,
    codePayement: 0
  };

  constructor(private ticketService: TicketService) { }

  ngOnInit(): void {
    this.getAllTickets();
  }

  getAllTickets(): void {
    this.ticketService.findAll().subscribe(
      (data: ticket[]) => {
        this.tickets = data;
        this.loading = false;
      },
      error => {
        console.error('Error fetching tickets', error);
        this.loading = false;
      }
    );
  }

  deleteTicket(id: number | undefined): void {
    if (id !== undefined) {
      this.ticketService.delete(id).subscribe(
        () => {
          this.tickets = this.tickets.filter(ticket => ticket.id !== id);
        },
        error => {
          console.error('Error deleting ticket', error);
        }
      );
    }
  }

  addTicket(): void {
    this.ticketService.save(this.newTicket).subscribe(
      (data: ticket) => {
        this.tickets.push(data);
        this.newTicket = { nomclient: '', prix: 0, codePayement: 0 }; // Reset form
      },
      error => {
        console.error('Error adding ticket', error);
      }
    );
  }
}
