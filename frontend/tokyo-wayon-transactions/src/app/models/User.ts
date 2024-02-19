export class User {

    id?: string;
    name: string;
    account: number;
    amount: number;
    active?:boolean
    constructor() {
        this.name = '';
        this.account = 0;
        this.amount = 0;
    }
    
}
