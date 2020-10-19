import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UseCase } from '../models/use-case';

@Injectable({
  providedIn: 'root'
})
export class UsecaseService {

  constructor(private http:HttpClient) { }


  public UseCaseSubmit(useCase:UseCase):Observable<any> {


    

    return this.http.post<any>("http://localhost:8080/api/usecase",useCase)
   
}



public deleteUseCase(id:number):Observable<any> {


  return this.http.post<any>("http://localhost:8080/api/delete",id)
 
 }
 
   
}
