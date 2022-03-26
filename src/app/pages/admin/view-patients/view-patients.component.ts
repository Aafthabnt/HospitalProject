import { Component, OnInit } from '@angular/core';
import { PatientsService } from 'src/app/services/patients.service';
import Swal from 'sweetalert2';
import { Patient } from '../../patientappointment/Patient';

@Component({
  selector: 'app-view-patients',
  templateUrl: './view-patients.component.html',
  styleUrls: ['./view-patients.component.css']
})
export class ViewPatientsComponent implements OnInit {

  constructor(private _patients:PatientsService) { }
  patients1!:Patient[];
  ngOnInit(): void {

    this._patients.patients().subscribe((data:any)=>{
      this.patients1=data;
      console.log(this.patients1);
 },
 (error)=>{
   console.log("error");
  Swal.fire("Error!!","Error in loading data","error");
});

  }

}
