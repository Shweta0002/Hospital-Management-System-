import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Patient } from '../entity/patient';
import { HospitalService } from '../service/hospital.service';

@Component({
  selector: 'app-patient-details',
  templateUrl: './patient-details.component.html',
  styleUrls: ['./patient-details.component.css']
})
export class PatientDetailsComponent implements OnInit {

  patient: Patient = new Patient();
  id: number;
  numberOfPatients!: number;

  constructor(private route: ActivatedRoute, private router: Router, private service: HospitalService) {
    this.id = route.snapshot.params['id'];
  }

  ngOnInit(): void {
    this.getPatientDetails()
    //this.service.getNumberOfPatients(this.id).subscribe(num => this.numberOfPatients = num);
  }

  getPatientDetails() {
    this.service.getPatient(this.id).subscribe(pat => {  this.patient=pat;});
    console.log("error here please check");

  }

  


}
