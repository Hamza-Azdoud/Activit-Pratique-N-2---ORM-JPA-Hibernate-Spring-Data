package ma.enset.studentsapp2.web;

import ma.enset.studentsapp2.PatientRepository;
import ma.enset.studentsapp2.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientRestService {
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patients")
    public List<Patient> patients(){
        return patientRepository.findAll();
    }
    @GetMapping("/patients/{id}")
    public Patient findById(@PathVariable Long id){
        return patientRepository.findById(id).get();
    }
}
