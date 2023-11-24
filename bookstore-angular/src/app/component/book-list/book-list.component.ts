import { Component, Input, OnInit } from '@angular/core';


import { Book } from '../../model/Book';
import { SearchBarService } from '../../service/search-bar.service';
import { BookDataService } from '../../service/book-data.service';



@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.scss'],
})
export class BookListComponent {
  @Input() books: any = [];

  constructor(private searchBarService: SearchBarService, private bookDataService: BookDataService) {}

  coverSearch(cover: string, size: string = "M") {
    console.log(`https://covers.openlibrary.org/b/id/${cover}-${size.toUpperCase()}.jpg`)
    return `https://covers.openlibrary.org/b/id/${cover}-${size.toUpperCase()}.jpg`
  }
  // searchBook(title: string){
  //   this.bookDataService.getBook(title).subscribe(book => this.books.push(book));
  // }
}
