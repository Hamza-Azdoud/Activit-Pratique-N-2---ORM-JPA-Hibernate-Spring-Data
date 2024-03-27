package ma.enset.studentsapp2;

import ma.enset.studentsapp2.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class StudentsApp2Application implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository;
    public static void main(String[] args) {
        SpringApplication.run(StudentsApp2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //patientRepository.save(new Patient(null,"N1", new Date(12,05,2021),true,250));
        //patientRepository.save(new Patient(null,"N2",new Date(26,03,2023),false,170));
        //patientRepository.save(new Patient(null,"N3",new Date(14,11,2022),true,300));
        List<Patient> patients = patientRepository.findAll();
        patients.forEach(p ->{
            System.out.println(p.toString());
        });

        Patient patient=patientRepository.findById(Long.valueOf(16)).get();
        System.out.println("*************");
        System.out.println(patient.getId());
        System.out.println(patient.getName());
        System.out.println(patient.getDateNaissanec());
        System.out.println(patient.isMalade());
        System.out.println(patient.getScore());
        System.out.println("*************");

        List<Patient> patientList= patientRepository.findByNameContains("N");
        patientList.forEach(p->{
            System.out.println(p);
        });

        System.out.println("----------------------");
        List<Patient> patientList2= patientRepository.search("%N%");
        patientList2.forEach(p->{
            System.out.println(p);
        });

        System.out.println("----------------------");
        List<Patient> patientList3= patientRepository.findByScoreGreaterThan(200);
        patientList3.forEach(p->{
            System.out.println(p);
        });
    }
}
