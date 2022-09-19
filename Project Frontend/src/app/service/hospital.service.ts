import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Doctor } from '../entity/doctor';
import { Patient } from '../entity/patient';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
  }),
};
@Injectable({
  providedIn: 'root'
})
export class HospitalService {

  private apiUrl: string = "http://localhost:8086/";

  constructor(private http: HttpClient) { }

  getDoctors():Observable<Doctor[]>{
    return this.http.get<Doctor[]>(this.apiUrl + "doctors");
  }

  getPatients():Observable<Patient[]>{
    return this.http.get<Patient[]>(this.apiUrl + "patients");
  }

  getDoctor(id: number):Observable<Doctor>{
    return this.http.get<Doctor>(this.apiUrl + "doctors/" + id);
  }

  addDoctor(doctor: Doctor):Observable<Doctor>{
    return this.http.post<Doctor>(this.apiUrl + "doctors",doctor);
  }

  getNumberOfPatients(id:number):Observable<number>{
    return this.http.get<number>(this.apiUrl + "doctors/" + id + "/patients");
  }

  getPatient(id:number):Observable<Patient>{
    return this.http.get<Patient>(this.apiUrl + "patients/"+id);
  }

  addPatient(patient:Patient,doctorId:number):Observable<Patient>{
    return this.http.post<Patient>(this.apiUrl + "patients/"+doctorId,patient);
  }

}
