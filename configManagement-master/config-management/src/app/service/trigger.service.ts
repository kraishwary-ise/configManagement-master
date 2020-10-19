import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { NameEmail } from '../models/triggerDrag';

@Injectable({
  providedIn: 'root'
})
export class TriggerService {

  constructor(private http:HttpClient) {

    
   }


   public getTrigger():Observable<any> {
     
    return this.http.get<any>("http://localhost:8080/api/getTrigger");
   }


   public saveTrigger(nameEmail:Array<NameEmail>):Observable<any> {


    return this.http.post<any>("http://localhost:8080/api/saveTrigger",nameEmail);

   }


}
