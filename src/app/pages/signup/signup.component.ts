import { Component, OnInit } from '@angular/core';
import { DocterService } from 'src/app/services/docter.service';
import {MatSnackBar} from '@angular/material/snack-bar';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private docterService : DocterService,private _snackBar: MatSnackBar) { }

  public docter={
    username:'',
    password:'',
    firstName:'',
    lastName:'',
    specialization:'',
    phone:'',
  }

  ngOnInit(): void {
  }

  formSubmit(){
    if(this.docter.username==''||this.docter.username==null){
     // alert('User is required!!');
     //used as message alert popup
     this._snackBar.open("Username is required !!"," ",{
       duration:3000,
     });
      return;
    }
    else{
    this.docterService.addDocter(this.docter).subscribe(
      (data :any)=>{
      console.log(data);
      //alert("success");
      //sweetalert module
      Swal.fire('Successfully done','user id is ' + data.id,'success')
    },(error)=>{
      console.log(error);
      this._snackBar.open('something went wrong !!','',{
        duration:3000,
      });
    });
  }
  }

  

}
