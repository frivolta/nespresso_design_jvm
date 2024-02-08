package nespresso.hospital.Patient;

import nespresso.hospital.Treatment.TreatmentType;

import java.util.List;

public class FeverState implements PatientState{
    @Override
    public void applyTreatments(Patient patient, List<TreatmentType> treatmentTypes) {
        if(treatmentTypes.contains(TreatmentType.ASPIRIN) || treatmentTypes.contains(TreatmentType.PARACETAMOL)){
            patient.setState(new HealthyState());
        }
    }


    @Override
    public void waitWithoutTreatment(Patient patient) {

    }

    @Override
    public String getCode() {
        return "F";
    }
}
