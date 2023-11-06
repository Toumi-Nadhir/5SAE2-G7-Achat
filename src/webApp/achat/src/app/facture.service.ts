import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


const API_URL = "http://192.168.240.128:9999/SpringMVC/facture/"

@Injectable({
  providedIn: 'root'
})
export class FactureService {

  constructor(private _http : HttpClient ) { }


  getFactures() : Observable<any[]>{
    return this._http.get<any[]>(API_URL + "retrieve-all-factures");
  }


  addFacture(facture : any) : Observable<any>{
    return this._http.post<any>(API_URL + "add-facture/" , facture);
  }



}
