import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Doctor } from 'src/app/entity/doctor';
import { Patient } from 'src/app/entity/patient';
import { HospitalService } from 'src/app/service/hospital.service';

@Component({
  selector: 'app-add-patient',
  templateUrl: './add-patient.component.html',
  styleUrls: ['./add-patient.component.css']
})
export class AddPatientComponent implements OnInit {

  patient: Patient = new Patient();

  doctors: Doctor[] = [];

  selectedDoctorId!: number;

  constructor(private service: HospitalService, private router: Router) { }

  ngOnInit(): void {
    this.service.getDoctors().subscribe(doctors => this.doctors = doctors);
  }

  onSubmit() {
    this.service.addPatient(this.patient, this.selectedDoctorId).subscribe(pat => console.log(pat.patientId));
    this.router.navigate(['patient']) .then(() => {
      window.location.reload();
    });
  }

  }
