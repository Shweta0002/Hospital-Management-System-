import { Component, OnInit } from '@angular/core';
import { Doctor } from 'src/app/entity/doctor';
import { HospitalService } from 'src/app/service/hospital.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-doctors',
  templateUrl: './doctors.component.html',
  styleUrls: ['./doctors.component.css']
})
export class DoctorsComponent implements OnInit {

  doctors: Doctor[] = [];
  key!: string;
  constructor(private service: HospitalService, private router: Router) {
  }

  
  ngOnInit(): void {
    this.getDoctors();
  }
  
  private getDoctors() {
    this.service.getDoctors().subscribe((list) => this.doctors = list);
  }
  onDetails(id: number) {
    this.router.navigate(['doctor', id]);
  }

  onSearch() {
    const result: Doctor[] = [];
    this.doctors.forEach(doc => {
      if (doc.name.toLocaleLowerCase().indexOf(this.key.toLocaleLowerCase()) !== -1) {
        result.push(doc);
      }
    });
    this.doctors = result;
    if (result.length === 0 || !this.key) {
      this.getDoctors();
    }
  }
}
