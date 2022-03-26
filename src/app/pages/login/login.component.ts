import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginData={
    username:'',password:''
  };

  constructor(private snack:MatSnackBar,private login:LoginService,private route:Router) { }

  formSubmit(){
    console.log('login btn clicked');

    if(this.loginData.username.trim()==''||this.loginData.username==null){
      this.snack.open("username is required !! ",'',{duration:3000,});
      return;

    }

    //request to server to generate token
    this.login.generateToken(this.loginData).subscribe((data: any) => {
      console.log("success");
      console.log(data);

      this.login.loginUser(data.token);
       this.login.getCurrentUser().subscribe(
         (user:any)=> {
           this.login.setUser(user);
           console.log(user);
           //redirect to Admin
           //redirect to Normal
           if(this.login.getUserRole()=="ADMIN"){
             //admin dashboard
             this.route.navigate(['admin'])
           }
           else if(this.login.getUserRole()=="NORMAL"){
             //normal user dashboard
            this.route.navigate(['docter'])
           }
           else{
             this.login.logout();
           }
         }
       );

    },
    (error)=>{
      console.log('Error !');
      console.log(error);
      this.snack.open("Invalid Details !! Try again",'',{duration:3000})
    });
  }

  

  ngOnInit(): void {
  }

}
