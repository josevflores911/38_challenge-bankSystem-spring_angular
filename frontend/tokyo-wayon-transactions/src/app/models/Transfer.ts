export class Transfer {
    id: string;
    idSender: string;
    idReceiver: string;
    nameReceiver: string;
    amount: number;
    fee: number;
    date?: Date;
    text?: string;
    aproved?: boolean;

    constructor(id:string='',idSender:string='',idReceiver:string='',nameReceiver:string='',amount:number=0,fee:number=0,date:Date = new Date(),text:string='') {
        this.id = id;
        this.idSender = idSender;
        this.idReceiver = idReceiver;
        this.nameReceiver = nameReceiver;
        this.amount = amount;
        this.fee = fee;
        
    }


}
