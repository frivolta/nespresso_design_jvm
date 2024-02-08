package nespresso.hospital.Report;

import nespresso.hospital.Patient.Patient;
import nespresso.hospital.Patient.PatientState;

import java.util.*;

public class Report {
    List<Patient> patients;
    String report;
    Map<String, Integer> reportMap = new LinkedHashMap<>();
    public Report(List<Patient> patients){
        this.patients = patients;
        this.report="";
    }

    private void generateReportMap(){
        reportMap.put("F",0);
        reportMap.put("H",0);
        reportMap.put("D",0);
        reportMap.put("T",0);
        reportMap.put("X",0);
        for(Patient patient:patients){
            PatientState ps = patient.getState();
            this.reportMap.put(ps.getCode(), this.reportMap.get(ps.getCode())+1);
        }
    }

    private void generateReport(){
        List<String> reportArr = new ArrayList<>();
        for(Map.Entry<String, Integer> entry:reportMap.entrySet()){
            reportArr.add(entry.getKey()+":"+entry.getValue());
        }
        this.report = String.join(" ", reportArr);
    }

    public Map<String, Integer> getReportMap(){
        this.generateReportMap();
        return this.reportMap;
   }
   public String getReport(){
        this.generateReportMap();
        this.generateReport();
        return this.report;
   }
}
