import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../environments/environments';
import { Observable } from 'rxjs';
import { Transfer } from '../models/Transfer';
import { TransferDetailRequest } from '../models/TransferDetailRequest';

@Injectable({
  providedIn: 'root'
})
export class TransferService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }


  public getAllTransactionsByUserId(id:string): Observable<Transfer[]> {
    return this.http.get<Transfer[]>(`${this.apiServerUrl}/transactions/user/${id}`);
  }

  //request a new transfer
  public createTransfer(transferDetailRequest: TransferDetailRequest): Observable<Transfer> {
    return this.http.post<Transfer>(`${this.apiServerUrl}/transactions`, transferDetailRequest );
}
}
