import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }
  public generateToken(loginData: any){
    return this.http.post(`${baseUrl}/generate-token`,loginData);
  }

  //login user set token in localStorage
  public loginUser(token: any){
    localStorage.setItem('token', token);
    return true;
  }
  //check docter is login or not

  public isLoggedIn(){
    let tokenStr=localStorage.getItem("token");
    if(tokenStr==undefined || tokenStr== ' ' || tokenStr== null){
    return false;}
    else{
      return true;
    }

  }
//logout:remove token
public logout(){
localStorage.removeItem('token');
return true;
}
//when i want token
public getToken(){
  return localStorage.getItem('token');
}
//set userDetail
public setUser(user :any){
localStorage.setItem('user',JSON.stringify(user));
}
//get user
public getUser(){
  let userStr=localStorage.getItem("user");
  if(userStr!=null){
    return JSON.parse(userStr);
  }else{
    this.logout();
    return null;
  } 
}

//get user role

public getUserRole(){
  let user=this.getUser();
  return user.authorities[0].authority;
}

//current user loggedin
public getCurrentUser(){
  return this.http.get(`${baseUrl}/current-user`);
}

}
