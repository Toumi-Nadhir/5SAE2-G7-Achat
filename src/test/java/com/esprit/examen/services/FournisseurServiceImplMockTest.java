package com.esprit.examen.services;

import com.esprit.examen.entities.DetailFournisseur;
import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.repositories.FournisseurRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FournisseurServiceImplMockTest {


    @Mock
    private FournisseurRepository fournisseurRepository;

    @InjectMocks
    private FournisseurServiceImpl fournisseurServiceImpl;



    @Test
    void testRetrieveFournisseur() {

        DetailFournisseur detailFournisseur = new DetailFournisseur();
        detailFournisseur.setAdresse("bizerte");
        detailFournisseur.setEmail("hassen.bm@esprit.tn");
        detailFournisseur.setFournisseur(new Fournisseur());


        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setDetailFournisseur(detailFournisseur);
        fournisseur.setIdFournisseur(1L);
        Optional<Fournisseur> ofResult = Optional.of(fournisseur);
        when(fournisseurRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(fournisseur, fournisseurServiceImpl.retrieveFournisseur(1L));
        verify(fournisseurRepository).findById((Long) any());
    }



    @Test
    void testAddFournisseur() {
        DetailFournisseur detailFournisseur = new DetailFournisseur();
        detailFournisseur.setEmail("hassen.bm@esprit.tn");
        detailFournisseur.setFournisseur(new Fournisseur());

        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setCode("0000");
        fournisseur.setDetailFournisseur(detailFournisseur);
        assertSame(fournisseur, fournisseurServiceImpl.addFournisseur(fournisseur));
        verify(fournisseurRepository).save((Fournisseur) any());
    }
    }

