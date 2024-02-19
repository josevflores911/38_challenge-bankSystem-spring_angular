export class UserDetailRequest {
    account: String;
    userkey: String;
    constructor(account:String,userkey:String) {
        this.account = account;
        this.userkey = userkey;
    }
    
}