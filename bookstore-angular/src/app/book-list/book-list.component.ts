import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatDividerModule } from '@angular/material/divider';
import { MatListModule } from '@angular/material/list';
import { Book, BookSearch } from '../model/Book';
import { SearchBarService } from '../service/search-bar.service';

@Component({
  selector: 'app-book-list',
  standalone: true,
  imports: [CommonModule, MatDividerModule, MatListModule],
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.scss'],
})
export class BookListComponent {
  docs: Book[] = [];
  q: string = "";
  mode: string = "";

  constructor(private searchBarService: SearchBarService) {}

  searchBook(q: string, mode: string){
    this.searchBarService.searchBook(q, mode).subscribe(books => this.docs = books.docs);
  }
}
