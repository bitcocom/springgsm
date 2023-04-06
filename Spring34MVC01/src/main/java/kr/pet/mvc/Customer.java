package kr.pet.mvc;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Customer {
    private String phoneNumber;
    private String ownerName;
    private String petName;
    private String address;
    private String species;
    private int birthYear;
    private List<MedicalRecord> medicalRecords; // 진료 기록을 저장하는 리스트

    public Customer(String phoneNumber, String ownerName, String petName, String address, String species, int birthYear) {
        this.phoneNumber = phoneNumber;
        this.ownerName = ownerName;
        this.petName = petName;
        this.address = address;
        this.species = species;
        this.birthYear = birthYear;
        this.medicalRecords = new ArrayList<>(); // 빈 리스트로 초기화
    }

    // Getter, Setter 메서드 생략

    public void addMedicalRecord(MedicalRecord record) {
        medicalRecords.add(record);
    }

    public List<MedicalRecord> getMedicalRecords() {
        return medicalRecords;
    }
}
