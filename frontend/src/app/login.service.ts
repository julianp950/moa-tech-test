import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { HttpHeadersService } from './http-header.service';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  headers = new HttpHeaders().set('Access-Control-Allow-Origin',"http://localhost:8080/login");
  entity: string = 'login';
  
  constructor(private http:HttpClient, private httpHeadersService: HttpHeadersService) { }

  public login(userName:string, password:string): Observable<any> {
    return this.http.post(`http://${environment.ip}:${environment.port}/${this.entity}`,{userName, password},{headers: this.headers, responseType: 'text'},)
  }

  public checkIfLogged(token:string): any {
    return this.http.get(`http://${environment.ip}:8080/${this.entity}/token/${token}`, { headers: this.httpHeadersService.getHeaders() })
  }
}
