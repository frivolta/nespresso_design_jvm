package nespresso.hospital.Patient;

import nespresso.hospital.Treatment.TreatmentType;

import java.util.List;

public class Patient {
    private PatientState currentState;
    public Patient(PatientState initialState){
        this.currentState=initialState;
    }

    public PatientState getState(){
        return this.currentState;
    }
    public void setState(PatientState newState){
        this.currentState=newState;
    }
}
