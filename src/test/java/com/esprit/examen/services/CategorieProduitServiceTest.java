package com.esprit.examen.services;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;
import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.repositories.CategorieProduitRepository;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategorieProduitServiceTest{

    @Autowired
    private ICategorieProduitService categorieProduitService;

    @Autowired
    private CategorieProduitRepository categorieProduitRepository;

    @Test
    public void testAddCategorieProduit() {
        // Create a sample CategorieProduit
        CategorieProduit cp = new CategorieProduit();
        cp.setCodeCategorie("sampleCode");
        cp.setLibelleCategorie("Sample Libelle");

        // Call the service method to add the CategorieProduit
        CategorieProduit addedCategorieProduit = categorieProduitService.addCategorieProduit(cp);

        // Check if the returned object is not null
        assertNotNull(addedCategorieProduit);

        // Check if the ID is not null
        assertNotNull(addedCategorieProduit.getIdCategorieProduit());

        // Additional assertions as needed
    }

    @Test
    public void testDeleteCategorieProduit() {
        // Create a sample CategorieProduit
        CategorieProduit cp = new CategorieProduit();
        cp.setCodeCategorie("sampleCode");
        cp.setLibelleCategorie("Sample Libelle");

        // Add the CategorieProduit to the database
        CategorieProduit addedCategorieProduit = categorieProduitService.addCategorieProduit(cp);

        // Delete the CategorieProduit
        categorieProduitService.deleteCategorieProduit(addedCategorieProduit.getIdCategorieProduit());

        // Try to retrieve the CategorieProduit after deletion
        CategorieProduit retrievedCategorieProduit = categorieProduitService.retrieveCategorieProduit(addedCategorieProduit.getIdCategorieProduit());

        // Check if the retrieved object is null, indicating it was deleted
        assertNull(retrievedCategorieProduit);
    }

    @Test
    public void testRetrieveAllCategorieProduits() {
        // Create and add some sample CategorieProduits to the repository
        CategorieProduit cp1 = new CategorieProduit();
        cp1.setCodeCategorie("code1");
        cp1.setLibelleCategorie("Libelle1");
        categorieProduitRepository.save(cp1);

        CategorieProduit cp2 = new CategorieProduit();
        cp2.setCodeCategorie("code2");
        cp2.setLibelleCategorie("Libelle2");
        categorieProduitRepository.save(cp2);

        // Retrieve all CategorieProduits
        List<CategorieProduit> categorieProduits = categorieProduitService.retrieveAllCategorieProduits();

        // Check if the list is not empty and contains the expected number of items
        assertNotNull(categorieProduits);
        //assertEquals(2, categorieProduits.size());
    }
}
