import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './views/home/home.component';
import { AboutComponent } from './views/about/about.component';
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { UserComponent } from './views/user/user.component';
import { ContactComponent } from './views/contact/contact.component';
import { FormsModule } from '@angular/forms';
import { TransferComponent } from './views/transfer/transfer.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'about',
    component: AboutComponent
  },
  {
    path: 'contact',
    component: ContactComponent
  },
  {
    path: 'user',
    component: UserComponent
  },
  {
    path: 'transaction',
    component: TransferComponent
  },
  {
    path: '**',
    redirectTo: ''
  }
];



  const localModules=[CommonModule,BrowserModule,FormsModule]

@NgModule({
  imports: [RouterModule.forRoot(routes),...localModules],
  exports: [RouterModule]
})
export class AppRoutingModule { }
