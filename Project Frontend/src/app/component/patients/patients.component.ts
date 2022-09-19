import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Patient } from 'src/app/entity/patient';
import { HospitalService } from 'src/app/service/hospital.service';

@Component({
  selector: 'app-patients',
  templateUrl: './patients.component.html',
  styleUrls: ['./patients.component.css']
})
export class PatientsComponent implements OnInit {

  key!: string;
  patients: Patient[] = [];
  flagFound: boolean = true;
  constructor(private service: HospitalService, private router: Router) { }

  ngOnInit(): void {
    this.getPatients();
  }

  private getPatients() {
    this.service.getPatients().subscribe(patients => this.patients = patients);
  }

  onSearch() {
    const result: Patient[] = [];
    this.patients.forEach(pat => {
      if (pat.name.toLocaleLowerCase().indexOf(this.key.toLocaleLowerCase()) !== -1) {
        result.push(pat);
      }
    });
    this.patients = result;
    if (result.length === 0 || !this.key) {
      this.getPatients();
    }
  }
  
  onDetails(id: number) {
    this.router.navigate(['patient', id]);
  }
}
