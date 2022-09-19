import { Component, OnInit } from '@angular/core';
import { Doctor } from 'src/app/entity/doctor';
import { ActivatedRoute, Router } from '@angular/router';
import { HospitalService } from 'src/app/service/hospital.service';

@Component({
  selector: 'app-doctor-details',
  templateUrl: './doctor-details.component.html',
  styleUrls: ['./doctor-details.component.css']
})
export class DoctorDetailsComponent implements OnInit {

  doctor: Doctor = new Doctor();
  id: number;
  numberOfPatients!: number;

  constructor(private route: ActivatedRoute, private router: Router, private service: HospitalService) {
    this.id = route.snapshot.params['id'];
  }

  ngOnInit(): void {
    this.getDoctorDetails()
    this.service.getNumberOfPatients(this.id).subscribe(num => this.numberOfPatients = num);
  }

  getDoctorDetails() {
    this.service.getDoctor(this.id).subscribe(doc => {
      if (doc.gender.includes("f"))
        doc.gender = "Female";
      else
        doc.gender = "Male";
      this.doctor=doc;
    });

  }

}
