package nespresso.hospital.Patient;

import nespresso.hospital.Treatment.TreatmentType;

import java.util.List;

public class HealthyState implements PatientState{
    @Override
    public void applyTreatments(Patient patient, List<TreatmentType> treatmentTypes) {
        // healthy people catch Fever if antibiotic mixed with insulin.
        if(treatmentTypes.contains(TreatmentType.INSULIN) && treatmentTypes.contains(TreatmentType.ANTIBIOTIC)){
            patient.setState(new FeverState());
        }
    }


    @Override
    public void waitWithoutTreatment(Patient patient) {

    }

    @Override
    public String getCode() {
        return "H";
    }
}
