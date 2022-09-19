import { HttpClient } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';
import {HttpClientTestingModule , HttpTestingController} from '@angular/common/http/testing';
import { HospitalService } from './hospital.service';
import { Doctor } from '../entity/doctor';

describe('HospitalService', () => {
  let service: HospitalService;
  let http: HttpClient;
  let httpController: HttpTestingController;


  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [HospitalService],
    });
    service = TestBed.inject(HospitalService);
    http = TestBed.inject(HttpClient);
    httpController = TestBed.inject(HttpTestingController);


  });
  afterEach(() => {
    httpController.verify();
  });



  it('should be created', () => {
    
    expect(service).toBeDefined();
  });

  it('hostial service Api' ,()=> {
    const inputId = 3;
    let testData = new Doctor();
    testData.age=35;
    testData.doctorId=3;
    testData.gender='f';
    testData.name="Poornima";
    testData.speciality="neurologist";
    service.getDoctor(inputId).subscribe((data)=> expect(data).toEqual(testData));
    //const req = httpController.expectOne('doctor/:id');
    //expect(req.request.method).toEqual('GET');
    //req.flush(testData);


  });

});
