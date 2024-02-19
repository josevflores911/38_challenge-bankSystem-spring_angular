import { Component } from '@angular/core';
import { UserService } from '../../services/user.service';
import { HttpErrorResponse } from '@angular/common/http';
import { User } from '../../models/User';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss',
})
export class HomeComponent {

  public some:User[]=[]

  constructor() {}

  ngOnInit() {
    
  }
}
