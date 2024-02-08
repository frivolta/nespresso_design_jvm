package nespresso.hospital.Patient;

import nespresso.hospital.Treatment.TreatmentType;

import java.util.List;

public interface PatientState {
    void applyTreatments(Patient patient, List<TreatmentType> treatmentTypes);
    void waitWithoutTreatment(Patient patient);
    String getCode();
}
