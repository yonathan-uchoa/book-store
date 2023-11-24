import { Injectable } from '@angular/core';
import { DataService } from './data.service';
import { Book } from '../model/Book';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

const _url : string = 'http://localhost:8081/library';

@Injectable({
  providedIn: 'root'
})
export class BookDataService {
  constructor(private http: HttpClient) { }

  getBook(param: any) : Observable<Book[]> {
    let params = new HttpParams();
    Object.entries(param).forEach(([key, value]) => params = params.append(key, String(value)));
    console.log(params)
    const response = this.http.get<Book[]>(_url, {params: params});
    return response;

  }

  // getBookSearch(title: string) {
  //   console.log({ title });
  //   return this.dataService.getData('/library', { title });
  // }

}
