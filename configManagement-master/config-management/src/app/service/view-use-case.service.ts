import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LoginUser } from '../models/login-user';

@Injectable({
  providedIn: 'root'
})
export class ViewUseCaseService {

  email;

  constructor(private http:HttpClient) { 
}


getListUseCase():Observable<any> {


this.email = sessionStorage.getItem('authenticateUser')


  return this.http.get<any>("http://localhost:8080/api/dashboard")
  



}

importUseCase(formData:FormData):Observable<any> {


  console.log(formData);
  return this.http.post<any>("http://localhost:8080/api/importUseCase",formData);
  



}



}
