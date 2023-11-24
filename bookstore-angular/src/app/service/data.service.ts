import { Injectable } from '@angular/core';
import { AppComponent } from '../app.component';
import { HttpClient, HttpHeaders, HttpParams, provideHttpClient } from '@angular/common/http';
import { Observable, lastValueFrom } from 'rxjs';


const _url : string = 'http://localhost:8081';

@Injectable({
  providedIn: 'root'
})

export class DataService {

  constructor(private http: HttpClient) { }

  // getLoggedInUser(auth_token : string):Observable<any> {
  //   const headers = new Headers({
  //     'Content-type': 'application/json',
  //     'Authorization': `Bearer ${auth_token}`
  //   })
  //   return this.http.get()
  // }


  getData(url: string, param: any) {
    let params = new HttpParams();
    Object.entries(param).forEach(([key, value]) => params = params.append(key, String(value)));
    const response = this.http.get(_url.concat(url), {params: params});
    return response;

  }
  postData(body: string) {
    return this.http.post(_url, body)
  }
}
