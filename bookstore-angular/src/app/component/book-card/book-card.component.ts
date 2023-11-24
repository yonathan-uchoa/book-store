import { Component, Input } from '@angular/core';
import { Book } from '../../model/Book';

@Component({
  selector: 'app-book-card',
  templateUrl: './book-card.component.html',
  styleUrls: ['./book-card.component.scss'],
})
export class BookCardComponent {
  @Input() books : any = [];

}
