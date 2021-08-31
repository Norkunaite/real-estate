import { Injectable } from '@angular/core';
import { RegisterPayload } from './register-payload';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { LoginPayload } from './login-payload';
import { JwtAuthResponse } from './jwt-auth-response';
import { LocalStorageService } from 'ngx-webstorage';
import { map } from 'rxjs/operators';

const authHeaders = {
  headers: new HttpHeaders()
  .set('content-type', 'application/json')
  .set('Access-Control-Allow-Origin', '*'),
};

@Injectable({
  providedIn: 'root'
})



export class AuthService {

  private url = "http://localhost:8080/api/auth";

  constructor(private httpClient: HttpClient, private localStorageService: LocalStorageService) { }

  signup(registerPayload: RegisterPayload): Observable<any> {
    return this.httpClient.post(`${this.url}/signup`, registerPayload);
  }

  login(loginPayload: LoginPayload): Observable<boolean> {
    return this.httpClient.post<JwtAuthResponse>(`${this.url}/login`, loginPayload, authHeaders).pipe(map(data => {
      this.localStorageService.store('authenticationToken', data.authenticationToken);
      this.localStorageService.store('username', data.username);
      console.log(data.authenticationToken)
      return true;
    }));
  }

  logout() {
    this.localStorageService.clear('authenticationToken');
    this.localStorageService.clear('username');
  }

  isAuthenticated():boolean{
    return this.localStorageService.retrieve('username')!=null;
  }
}
