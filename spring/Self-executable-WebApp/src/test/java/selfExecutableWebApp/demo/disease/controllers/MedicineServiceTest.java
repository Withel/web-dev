package selfExecutableWebApp.demo.disease.controllers;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import selfExecutableWebApp.demo.disease.dao.Medicine;
import selfExecutableWebApp.demo.disease.repository.MedicineRepository;
import selfExecutableWebApp.demo.disease.service.MedicineService;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MedicineServiceTest {

    @Autowired
    MedicineService medicineService;

    @MockBean
    MedicineRepository repository;


    @Test
    public void justdo() {
        Medicine medicine = new Medicine();
        medicine.setName("Mucosolvan mini");
        medicine.setDescription("suchy");
        medicine.setActiveSubstance("Ambroksol");
        medicine.setDbId(167L);

        Mockito.when(repository.findByName("Mucosolvan mini")).thenReturn(medicine);
        assertEquals(medicine, (medicineService.findMedicineByName("Mucosolvan mini")));
    }

}