
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LandPayload } from './land-payload';
import { LocalStorageService } from 'ngx-webstorage'; 

const API_URL = 'http://localhost:8080/api/estates/lands';

@Injectable({
  providedIn: 'root'
})
export class LandService {

  constructor(private http: HttpClient, private localStorageService: LocalStorageService) { }

  getAllLands(): Observable<LandPayload[]> {
    return this.http.get<LandPayload[]>(`${API_URL}`);
  }

  createLand(land: LandPayload): Observable<any> {
    return this.http.post<any>(`${API_URL}`, land);
  }

  deleteLand(id: number): Observable<any> {
    return this.http.delete<any>(`${API_URL}/${id}`);
  }

  getLandById(id:number):Observable<LandPayload>{
    return this.http.get<LandPayload>(`${API_URL}/${id}`);
  }

  updateLand(id: number, land: LandPayload): Observable<any>{
    return this.http.put<any>(`${API_URL}/${id}`, land);
  }
}
