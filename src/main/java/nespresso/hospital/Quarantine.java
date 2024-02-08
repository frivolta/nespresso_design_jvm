package nespresso.hospital;

import nespresso.hospital.Patient.*;
import nespresso.hospital.Treatment.*;
import nespresso.hospital.Report.*;

import java.util.ArrayList;
import java.util.List;

public class Quarantine {
    List<Patient> patientsList;
    List<TreatmentType> treatmentTypes;
    Report report;
    public Quarantine(String rawPatients) throws Exception {
        this.patientsList = new ArrayList<>();
        this.treatmentTypes = new ArrayList<>();
        // generate patients from list
        this.generatePatientsList(rawPatients);
    }
    private void addTreatmentType(TreatmentType treatmentType){
        this.treatmentTypes.add(treatmentType);
    }

    private void generatePatientsList(String rawPatients)throws Exception{
        String[] patients = rawPatients.split(",");
        for(String patient:patients){
            switch(patient){
                case "F":
                    this.patientsList.add(new Patient(new FeverState()));
                    break;
                case "H":
                    this.patientsList.add(new Patient(new HealthyState()));
                    break;
                case "D":
                    this.patientsList.add(new Patient(new DiabateState()));
                    break;
                case "T":
                    this.patientsList.add(new Patient(new TubercolosisState()));
                    break;
                case "X":
                    this.patientsList.add(new Patient(new DeadState()));
                    break;
                default:
                    throw new IllegalArgumentException("invalid argument supplied to patient list");
            }
        }
    }

    public String report(){
        this.report = new Report(this.patientsList);
        return this.report.getReport();
    }

    public void wait40Days(){
        this.applyTreatmentStrategies();
    }
    private void applyTreatmentStrategies(){
        for(Patient patient:patientsList){
            if(treatmentTypes.isEmpty()){
                patient.getState().waitWithoutTreatment(patient);
            }else{
                patient.getState().applyTreatments(patient, this.treatmentTypes);
            }
        }
    }

    private void shouldKillAll(){
        if(this.treatmentTypes.contains(TreatmentType.ASPIRIN) && this.treatmentTypes.contains(TreatmentType.PARACETAMOL)){
            for(Patient patient:patientsList){
                patient.setState(new DeadState());
            }
        }
    }
    public void aspirin(){
        this.addTreatmentType(TreatmentType.ASPIRIN);
        this.shouldKillAll();
    }
    public void antibiotic(){
        this.addTreatmentType(TreatmentType.ANTIBIOTIC);
        this.shouldKillAll();
    }

    public void insulin(){
        this.addTreatmentType(TreatmentType.INSULIN);
        this.shouldKillAll();
    }

    public void paracetamol(){
        this.addTreatmentType(TreatmentType.PARACETAMOL);
        this.shouldKillAll();
    }
}