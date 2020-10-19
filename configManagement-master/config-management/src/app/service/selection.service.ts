import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { selectionDrop } from '../models/selectionDrag';

@Injectable({
  providedIn: 'root'
})
export class SelectionService {

  constructor(private http:HttpClient) { }


  public getSelection():Observable<any> {
     
    return this.http.get<any>("http://localhost:8080/api/getSelection");
   }


   public saveSelection(selectionDrag:Array<selectionDrop>):Observable<any> {


    return this.http.post<any>("http://localhost:8080/api/saveSelection",selectionDrag);

   }




}
