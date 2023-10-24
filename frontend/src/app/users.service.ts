import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { HttpHeadersService } from './http-header.service';

export interface User {
  id: number;
  name: string;
  age: number;
  phone: string;
  address: string;
  email: string;
  userName: string;
  password: string;
  role: any;
}

@Injectable({
  providedIn: 'root',
})
export class UsersService {
  entity: string = 'user';
  constructor(
    private http: HttpClient,
    private httpHeadersService: HttpHeadersService
  ) {}

  getAll(): Observable<User[]> {
    return this.http.get<User[]>(
      `http://${environment.ip}:${environment.port}/${this.entity}`
    );
  }

  getUserById(id: number): Observable<User> {
    return this.http.get<User>(
      `http://${environment.ip}:${environment.port}/${this.entity}/${id}`
    );
  }

  postUser(user: User): Observable<any> {
    return this.http.post(
      `http://${environment.ip}:${environment.port}/${this.entity}`,
      user,
      { headers: this.httpHeadersService.getHeaders() }
    );
  }

  putUser(user: User, id: number): Observable<any> {
    return this.http.put(
      `http://${environment.ip}:8080/${this.entity}/editUser/${id}`,
      user, 
      { headers: this.httpHeadersService.getHeaders() }
    );
  }

  deleteUser(id: number): void {
    this.http.delete(
      `http://${environment.ip}:${environment.port}/${this.entity}/deleteUser/${id}`, { headers: this.httpHeadersService.getHeaders() }
    ).subscribe({
      next: data => {
      },
      error: error => {
          console.error('There was an error!', error);
      }
  });;
  }
}
