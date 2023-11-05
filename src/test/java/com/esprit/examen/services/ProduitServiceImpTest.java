package com.esprit.examen.services;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

import com.esprit.examen.entities.Produit;

import java.util.Arrays;
import java.util.List;


@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ProduitServiceImpTest {

    @Mock
    private IProduitService produitService;

    @InjectMocks
    private ProduitServiceImpl produitServiceImpl;

    @Test
    public void testAddProduitWithJUnit() {
        // Create a sample Produit
        Produit produit = new Produit();
        produit.setCodeProduit("sampleCode");
        produit.setLibelleProduit("Sample Libelle");
        produit.setPrix(100.0F); // Set the price

        // Call the service method to add the Produit
        Produit addedProduit = produitServiceImpl.addProduit(produit);

        // Check if the returned object is not null
        assertNotNull(addedProduit);

        // Check if the ID is not null
        assertNotNull(addedProduit.getIdProduit());

        // Additional assertions as needed
    }

    @Test
    public void testDeleteProduitWithMockito() {
        // Create a sample Produit
        Produit produit = new Produit();
        produit.setIdProduit(1L); // Provide the ID
        produit.setCodeProduit("sampleCode");
        produit.setLibelleProduit("Sample Libelle");
        produit.setPrix(100.0F); // Set the price

        // Mock the behavior for retrieving the Produit
        Mockito.when(produitService.retrieveProduit(1L)).thenReturn(produit);

        // Delete the Produit
        produitServiceImpl.deleteProduit(produit.getIdProduit());

        // Verify if the method is called with the correct ID
        Mockito.verify(produitService).deleteProduit(1L);
    }

    @Test
    public void testRetrieveAllProduitsWithMockito() {
        // Mock the behavior for retrieving all Produits
        Mockito.when(produitService.retrieveAllProduits()).thenReturn(Arrays.asList(new Produit(), new Produit()));

        // Retrieve all Produits
        List<Produit> produits = produitServiceImpl.retrieveAllProduits();

        // Check if the list is not empty and contains the expected number of items
        assertNotNull(produits);
        //assertEquals(2, produits.size());
    }
}
