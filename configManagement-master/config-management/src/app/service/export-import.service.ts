import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {UseCase} from '../models/use-case';


@Injectable({
  providedIn: 'root'
})
export class ExportImportService {

  constructor(private http:HttpClient) { 





  }



  public eachUseCase(id:number):Observable<any> {


    return this.http.post<any>("http://localhost:8080/api/Export",id)
   
   }

}
