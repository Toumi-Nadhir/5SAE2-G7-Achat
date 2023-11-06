
package com.esprit.examen.services;

import com.esprit.examen.entities.Produit;
import com.esprit.examen.repositories.ProduitRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;





@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ProduitServiceImpTest {

    private ProduitRepository produitRepository =  Mockito.mock(ProduitRepository.class);;

    @InjectMocks
    private ProduitServiceImpl produitService ;
    @Autowired
    private ProduitRepository junitProRepo;
    @Autowired
    private IProduitService junIProduitService;

        List<Produit> produitList = new ArrayList() {
            {
                add(
                        Produit.builder()
                                .idProduit(555L)
                                .libelleProduit("Raed")
                                .prix(555L)

                                .build()

                );
            }};

        @Test
        void retrieveAllProduits() {

            Mockito.when(produitRepository.findAll()).thenReturn(produitList);
            List<Produit> produitList = produitService.retrieveAllProduits();
            assertFalse(produitList.isEmpty());
            verify(produitRepository).findAll();
        }

        @Test
        void addProduit() {
            Produit newProduit = Produit.builder()
                    .idProduit(555L)
                    .libelleProduit("Raed")
                    .prix(555L)
                    .build();
            Produit responseProduit = this.produitService.addProduit(newProduit);
            assertNotNull(responseProduit);
            assertEquals(newProduit.getIdProduit(),responseProduit.getIdProduit());
            this.produitService.deleteProduit(responseProduit.getIdProduit());

        }

        @Test
        void deleteProduit() {
        }

        @Test
        void updateProduit() {
        }

        @Test
        void retrieveProduit() {
        }
    }
