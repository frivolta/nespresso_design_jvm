package nespresso.hospital.Patient;

import nespresso.hospital.Treatment.TreatmentType;

import java.util.List;

public class TubercolosisState implements PatientState{
    @Override
    public void applyTreatments(Patient patient, List<TreatmentType> treatmentTypes) {
        if(treatmentTypes.contains(TreatmentType.ANTIBIOTIC)){
            patient.setState(new HealthyState());
        }else{
            this.waitWithoutTreatment(patient);
        }
    }

    @Override
    public void waitWithoutTreatment(Patient patient) {

    }

    @Override
    public String getCode() {
        return "T";
    }
}
