package com.esprit.examen.services;

import com.esprit.examen.entities.DetailFacture;
import com.esprit.examen.entities.Facture;
import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.entities.Operateur;
import com.esprit.examen.repositories.FactureRepository;
import com.esprit.examen.repositories.FournisseurRepository;
import com.esprit.examen.repositories.OperateurRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.mockito.Mockito.verify;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class FactureServiceImplTest {

//Facture
    private FactureRepository factureRepository =  Mockito.mock(FactureRepository.class);;

    @InjectMocks
    private FactureServiceImpl factureService ;

    @Autowired
    private FactureRepository junitFactRepo ;
    @Autowired
    private IFactureService junitfactureService ;

//    Fournisseur

    private FournisseurRepository fournisseurRepository =  Mockito.mock(FournisseurRepository.class);;
    @InjectMocks
    private FournisseurServiceImpl fournisseurService ;

//Operateur
    private OperateurRepository operateurRepository =  Mockito.mock(OperateurRepository.class);;
    @InjectMocks
    private OperateurServiceImpl operateurService ;


    List<Facture> factureList = new ArrayList(){
        {
            add(
                    Facture.builder()
                            .idFacture(1L)
                        .montantFacture(2333)
                        .dateCreationFacture(new Date(2023,05,23))
                        .archivee(false)
                            .build()
            );
            add(
                    Facture.builder()
                            .idFacture(2L)
                        .montantFacture(4444)
                        .dateCreationFacture(new Date(2023,10,03))
                        .archivee(true)
                            .build()
            );

        }
    };

    Facture facture = Facture.builder()
            .idFacture(3L)
            .montantFacture(33333)
            .dateCreationFacture(new Date(2023,1,30))
            .archivee(true)
            .build();

    Fournisseur fournisseur = Fournisseur.builder()
            .idFournisseur(4L)
            .factures(factureList)
            .code("test")
            .libelle("test fournisseur")
            .build();

    Operateur operateur = Operateur.builder()
            .idOperateur(2L)
            .factures(factureList)
            .nom("test")
            .prenom("test prenom")
            .build();

    @Test
    void retrieveAllFactures() {

        Mockito.when(factureRepository.findAll()).thenReturn(factureList);
        //TODO : Using Mockito

        List<Facture> factureList = factureService.retrieveAllFactures();

        assertFalse(factureList.isEmpty());

        verify(factureRepository).findAll();
    }


    @Test
    void addFacture() {

        Facture newFacture = Facture.builder()
                .idFacture(99L)
                .montantFacture(34.5F)
                .montantRemise(444)
                .build();

        Facture respFacture = this.junitfactureService.addFacture(newFacture);

        assertNotNull(respFacture);

        assertEquals(newFacture.getMontantRemise() , respFacture.getMontantRemise());


        this.junitfactureService.cancelFacture(respFacture.getIdFacture());

    }

    @Test
    void cancelFacture() {

        Facture newFacture = Facture.builder()
                .idFacture(99L)
                .montantFacture(34.5F)
                .montantRemise(444)
                .build();

        Facture respFacture = this.junitfactureService.addFacture(newFacture);

        assertNotNull(respFacture);

        assertEquals(newFacture.getMontantRemise() , respFacture.getMontantRemise());


        this.junitfactureService.cancelFacture(respFacture.getIdFacture());
    }

    @Test
    void retrieveFacture() {

        Mockito.when(factureRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(facture));


        Facture resFacture = factureService.retrieveFacture(Mockito.anyLong());

        assertNotNull(resFacture);

        verify(factureRepository).findById(Mockito.anyLong());


    }

    @Test
    void getFacturesByFournisseur() {

        Mockito.when(fournisseurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(fournisseur));

        List<Facture> facturesByFournisseur = factureService.getFacturesByFournisseur(Mockito.anyLong());

        assertFalse(facturesByFournisseur.isEmpty());

        verify(fournisseurRepository).findById(Mockito.anyLong());

    }

    @Test
    void assignOperateurToFacture() {
        Mockito.when(factureRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(facture));
        Mockito.when(factureRepository.save(facture)).thenReturn(facture);

        Mockito.when(operateurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(operateur));
        Mockito.when(operateurRepository.save(operateur)).thenReturn(operateur);


        factureService.assignOperateurToFacture(33L  , 66L);

        verify(factureRepository).findById(Mockito.anyLong());
        verify(operateurRepository).findById(Mockito.anyLong());


        verify(operateurRepository).save(operateur);

    }


}
