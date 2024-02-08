package nespresso.hospital.Patient;

import nespresso.hospital.Treatment.TreatmentType;

import java.util.List;

public class DiabateState implements PatientState{
    @Override
    public void applyTreatments(Patient patient, List<TreatmentType> treatmentTypes) {
        if(!treatmentTypes.contains(TreatmentType.INSULIN)){
            this.waitWithoutTreatment(patient);
        }
    }


    @Override
    public void waitWithoutTreatment(Patient patient) {
        patient.setState(new DeadState());
    }

    @Override
    public String getCode() {
        return "D";
    }
}
