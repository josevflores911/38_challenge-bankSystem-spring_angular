import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ToastModule } from 'primeng/toast';

const dialog = [
  ToastModule
]

@NgModule({
  declarations: [],
  imports: [
    ...dialog,
    CommonModule
  ],
  exports: [
    ...dialog
  ]
})
export class PrimeNGModule { }
