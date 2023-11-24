import { Component, EventEmitter, Input, Output } from '@angular/core';
import { BookDataService } from '../../service/book-data.service';
import { Book } from '../../model/Book';

@Component({
  selector: 'app-search-bar',
  templateUrl: './search-bar.component.html',
  styleUrls: ['./search-bar.component.scss']
})
export class SearchBarComponent {
  searchValue: any;
  @Output() books: any = new EventEmitter<any>();

  constructor(private bookDataService: BookDataService){}


  searchResult(title: any) {
    this.searchValue = title;
    console.log(title);
    this.bookDataService.getBook({title}).subscribe((data) => {
      console.log(data);
      this.books.emit(data);
    })
    //this.router.navigate(['/'], {queryParams: {p: text}})

  }

}
