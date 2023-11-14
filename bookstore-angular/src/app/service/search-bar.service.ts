import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BookSearch } from '../model/Book';

@Injectable({
  providedIn: 'root'
})
export class SearchBarService {
  private URL = 'http://localhost:8081/library'
  constructor(private http: HttpClient) { }

  searchBook(q: string, mode: string): Observable<BookSearch>{
    let queryParams = new HttpParams;
    if(q)
      queryParams =  queryParams.append("q", q);
    if(mode)
      queryParams = queryParams.append("mode", mode);

    return this.http.get<BookSearch>(this.URL,{params:queryParams});
  }
}
