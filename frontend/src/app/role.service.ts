import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { HttpHeadersService } from './http-header.service';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

export interface Role {
  id: number,
  name: string,
  create: boolean,
  update: boolean,
  delete: boolean,
}

@Injectable({
  providedIn: 'root'
})
export class RoleService {
  entity: string = 'role';
  constructor(private http: HttpClient, private httpHeadersService: HttpHeadersService) { }

  getAll(): Observable<Role[]> {
    return this.http.get<Role[]>(
      `http://${environment.ip}:${environment.port}/${this.entity}`
    );
  }

  getRoleById(id: number): Observable<Role> {
    return this.http.get<Role>(
      `http://${environment.ip}:${environment.port}/${this.entity}/${id}`
    );
  }
}
