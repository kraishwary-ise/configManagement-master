import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { offerDrop } from '../models/offerDrag';

@Injectable({
  providedIn: 'root'
})
export class OfferService {

  constructor(private http:HttpClient) { }


  public getOffer():Observable<any> {
     
    return this.http.get<any>("http://localhost:8080/api/getOffer");
   }

   public saveOffer(offerDrop:Array<offerDrop>):Observable<any> {

    console.log("ygy");

    console.log(offerDrop);


    return this.http.post<any>("http://localhost:8080/api/saveOffer",offerDrop);

   }


}
