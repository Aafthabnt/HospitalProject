import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Patient } from '../pages/patientappointment/Patient';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class PatientsService {

  constructor(private _http:HttpClient) { }
  public patients(){
    return this._http.get(`${baseUrl}/patients`);
  }
  public sendPatients(patient:Patient){
    return this._http.post(`${baseUrl}/patients`,this.patients);
  }
}
