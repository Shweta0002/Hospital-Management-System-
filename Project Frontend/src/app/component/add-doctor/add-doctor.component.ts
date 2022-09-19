import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Doctor } from 'src/app/entity/doctor';
import { HospitalService } from 'src/app/service/hospital.service';

@Component({
  selector: 'app-add-doctor',
  templateUrl: './add-doctor.component.html',
  styleUrls: ['./add-doctor.component.css']
})
export class AddDoctorComponent implements OnInit {

  doctor: Doctor = new Doctor();

  constructor(private service: HospitalService,private router:Router) { }

  ngOnInit(): void {
  }

  onSubmit() {
    this.service.addDoctor(this.doctor).subscribe(doc=>console.log(doc.doctorId));
    this.router.navigate(['doctors']) .then(() => {
      window.location.reload();
    });
  }
}