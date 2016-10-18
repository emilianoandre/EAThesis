/**
 * Authentication Service
 * @author eandre
 * 
 */

import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../../user/user';

var users = [
             new User('admin@admin.com','adm9'),
             new User('user1@gmail.com','a23')
             ];

@Injectable()
export class AuthenticationService {
    
    constructor(
            private _router: Router){}
    
    logout() {
        localStorage.removeItem("user");
        this._router.navigate(['Login']);
    }
    
    login(user){
        var authenticatedUser = users.find(u => u.email === user.email);
        if (authenticatedUser && authenticatedUser.password === user.password) {
            localStorage.setItem("user", authenticatedUser.email);
            this._router.navigate(['Home']);      
            return true;
        }
        return false;
        
    }
    
    checkCredentials(){
        if (localStorage.getItem("user") === null) {
            this._router.navigate(['Login']);
        }
    } 
}