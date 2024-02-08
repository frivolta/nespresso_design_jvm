package nespresso.hospital.Patient;

import nespresso.hospital.Treatment.TreatmentType;

import java.util.List;

public class DeadState implements PatientState{
    @Override
    public void applyTreatments(Patient patient, List<TreatmentType> treatmentTypes) {

    }


    @Override
    public void waitWithoutTreatment(Patient patient) {

    }

    @Override
    public String getCode() {
        return "X";
    }


}
