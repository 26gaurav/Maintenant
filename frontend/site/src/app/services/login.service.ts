import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  authenticate(user: any) {
    //console.log('before ' + this.isUserLoggedIn());

    if(user.role=== 'admin'){
      return this.http.post(`${baseUrl}/admin/login/`, user);

    }else if(user.role=== 'user'){
      return this.http.post(`${baseUrl}/user/login/`, user);

    }else{
      return this.http.post(`${baseUrl}/worker/login/`, user);
    }
  }

  //set userDetail
  public setUser(user : any) {
    localStorage.setItem('user', JSON.stringify(user));
  }

  isUserLoggedIn() {
    let user = localStorage.getItem('user')
    return !(user === null)
  }

  //getUser
  public getUser() {
    let userStr = localStorage.getItem('user');
    if (userStr != null) {
      return JSON.parse(userStr);
    } else {
      this.logout();
      return null;
    }
  }

  logout(){
    localStorage.removeItem('user')
  }
}
