import { Component, Output } from '@angular/core';
import { Book } from 'src/app/model/Book';

const ROWS_HEIGHT: { [id: number]: number } = { 1: 400, 3: 335, 4: 350 };

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent {
  books: any = [];
  cols = 3;
  rowHeight: number = ROWS_HEIGHT[this.cols];


  getBooks(books: Book[]){
    this.books = books;
  }
}
