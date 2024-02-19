import { Injectable } from '@angular/core';
import { environment } from '../environments/environments';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, retry } from 'rxjs';
import { User } from '../models/User';
import { UserDetailRequest } from '../models/UserDetailRequest';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) {}

  //getAll
  public getAllUsers(): Observable<User[]> {
    return this.http.get<User[]>(`${this.apiServerUrl}/users/getall`);
  }

  //getByAccountAnduserkey
  public getUserByAccountAndUserkey(userDetailRequest: UserDetailRequest): Observable<User> {
      return this.http.post<User>(`${this.apiServerUrl}/users/account`, userDetailRequest );
  }

  public getUserById(id: string): Observable<User> {
    return this.http.get<User>(`${this.apiServerUrl}/users/get/${id}`);
  }
}
