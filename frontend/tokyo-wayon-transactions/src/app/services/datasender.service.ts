import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DatasenderService {

  private message = new BehaviorSubject('');
  getMessage = this.message.asObservable();

  constructor() { }

  setMessage(message: string) {
    this.message.next(message)
  }
}
