import { HttpClient} from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class DocterService {

  constructor(private http:HttpClient,) { 
    
  }

  public addDocter(docter: any){
    return this.http.post(`${baseUrl}/doctor/`,docter)
  }
}
