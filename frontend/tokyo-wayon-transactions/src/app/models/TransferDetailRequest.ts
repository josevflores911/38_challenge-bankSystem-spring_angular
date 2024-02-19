export class TransferDetailRequest {
    idSender: string;
    accountReceiver: String;
    amountSend: number;
    scheduledDate: Date;
    todayDate: Date = new Date(Date.now());
    optionalText?: String;

    constructor(idSender: string="",accountReceiver: String="",amountSend: number=0,scheduledDate: Date=new Date(),optionalText: String="") {
    
        this.idSender = idSender;
        this.accountReceiver = accountReceiver;
        this.amountSend = amountSend;
        this.scheduledDate = scheduledDate;
        this.optionalText=optionalText;
    }
}
