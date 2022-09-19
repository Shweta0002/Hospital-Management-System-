import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { DoctorsComponent } from './component/doctors/doctors.component';
import { AddDoctorComponent } from './component/add-doctor/add-doctor.component';
import { AddPatientComponent } from './component/add-patient/add-patient.component';
import { DoctorDetailsComponent } from './component/doctor-details/doctor-details.component';
import { PatientsComponent } from './component/patients/patients.component';
import { PatientDetailsComponent } from './patient-details/patient-details.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  declarations: [
    AppComponent,
    DoctorsComponent,
    AddDoctorComponent,
    AddPatientComponent,
    DoctorDetailsComponent,
    PatientsComponent,
    PatientDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule, 
    FormsModule,
    HttpClientModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
