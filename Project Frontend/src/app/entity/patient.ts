import { Doctor } from "./doctor";

export class Patient{
    patientId!: number;
    name!: string;
    visitedDoctor!:string
    dateOfVisit!: Date;
    prescription!: string;
}