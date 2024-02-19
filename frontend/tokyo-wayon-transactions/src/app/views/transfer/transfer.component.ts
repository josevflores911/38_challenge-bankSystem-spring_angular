import { Component } from '@angular/core';
import { DatasenderService } from '../../services/datasender.service';
import { TransferService } from '../../services/transfer.service';
import { User } from '../../models/User';
import { UserService } from '../../services/user.service';
import { HttpErrorResponse } from '@angular/common/http';
import { Transfer } from '../../models/Transfer';
import { TransferDetailRequest } from '../../models/TransferDetailRequest';

@Component({
  selector: 'app-transfer',
  templateUrl: './transfer.component.html',
  styleUrl: './transfer.component.scss'
})
export class TransferComponent {
  
  idMessage: string = "";
  
  user: User = new User;
  transferList: Transfer[] = [];
  
  flagAllTransactions: boolean = false;
  
  accountReceiver: string = '';
  amountSend: number = 0;
  dateNow: Date = new Date(Date.now())
  scheduledDate:Date =new Date()

  constructor(private dataSenderService:DatasenderService, private transferService:TransferService, private userService:UserService) {
    this.dataSenderService.getMessage.subscribe(msg => this.idMessage = msg);

    console.log(this.idMessage+"debuging")
     this.getUserData(this.idMessage);
     this.getAllTransactions(this.idMessage);
  }

  ngOnInit():void {
    // ...
  }

  async getUserData(arg: string): Promise<void> {

    await this.userService.getUserById(arg).subscribe({
      complete: () => { console.log("finish getUserData")  }, 
      error: (err: HttpErrorResponse) => { console.log(err) }, 
      next: (res: User) => {
        this.user = res;
      }, 
    });
  }

  async getAllTransactions(id: string):Promise<void> {
    await this.transferService.getAllTransactionsByUserId(id).subscribe({
      complete: () => {console.log("finish getAllTransactions") },
      error: (err) => { },
      next: (res) => {
        this.transferList = res
        this.getNames(res);
      }
    })
  }

  async getNames(arg: Transfer[]):Promise<void> {  
    await arg.forEach((ev) => {
      this.userService.getUserById(ev.idReceiver).subscribe({
        complete: () => {console.log("finish getNames") },
        error: (err) => {console.log("error looking name" ) },
        next: (res) => {
          ev.nameReceiver=res.name     
        }
      })
    })
  }

  
  createTransaction():void {
    
    const request = this.validateTransaction(this.amountSend, this.accountReceiver);

    if (request != null) {
      this.transferService.createTransfer(request).subscribe({
        complete: () => {console.log("finish createTransfer") },
        error: (err) => { },
        next: (res) => {
          console.log("debugging")
          console.log(res)
          if (res) {
            this.transferList=[...this.transferList,res]
          }
        }
      })
  
      this.getUserData(this.idMessage);
      
      this.flagAllTransactions = true;
    } else {
      console.log("not valid operation")
    }
    this.flagAllTransactions = true;
  }

  
  removeTransaction(id:string) {
    console.log(id);
    console.log(this.transferList)
    this.transferList.filter(el=>el.id==id).map(el=>el.aproved=false) 
  }
  
  showAllTransactions() {
    this.flagAllTransactions=true
  }
  
  hideAllTransactions() {
    this.flagAllTransactions = false;
  }

  private validateTransaction(amount:number,accountReceiver:string) {
    if (amount > this.user.amount) {
      throw "amount not available in account";
    }
    else if (accountReceiver == (this.user.account).toString()) {
      throw "this operation is not valid"
    } else {  
      return new TransferDetailRequest(this.user.id, this.accountReceiver, this.amountSend, new Date(this.scheduledDate));
    }    
  }

  private calculateDateDifference(startDate: Date, endDate: Date) {
    
    const startUtc = Date.UTC(startDate.getFullYear(), startDate.getMonth(), startDate.getDate());
    const endUtc = Date.UTC(endDate!.getFullYear(), endDate!.getMonth(), endDate!.getDate());
    const timeDiff = endUtc - startUtc;
    const daysDiff = Math.floor(timeDiff / (1000 * 60 * 60 * 24));
  
    return daysDiff;
  }
}
