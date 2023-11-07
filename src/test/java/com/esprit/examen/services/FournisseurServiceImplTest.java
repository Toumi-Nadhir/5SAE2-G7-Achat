package com.esprit.examen.services;

import com.esprit.examen.entities.CategorieFournisseur;
import com.esprit.examen.entities.Fournisseur;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class FournisseurServiceImplTest {
    @Autowired
    IFournisseurService FournisseurService;

    @Test
    public void testAddFournisseur()
    {
        Fournisseur f= new Fournisseur();
        f.setCode("codeexemple");
        f.setLibelle("NNNN");
        f.setCategorieFournisseur(CategorieFournisseur.CONVENTIONNE);
        FournisseurService.addFournisseur(f);
        System.out.println("Le Code Test du Fournisseur => "+f.getCode());
        assertNotNull(f.getIdFournisseur());
        assertNotNull(f.getCategorieFournisseur());
        FournisseurService.deleteFournisseur(f.getIdFournisseur());

    }

    @Test
    public void testDeleteFournisseur()
    {
        Fournisseur f= new Fournisseur();
        f.setCode("testDelete");
        f.setLibelle("NNNN");
        f.setCategorieFournisseur(CategorieFournisseur.CONVENTIONNE);
        FournisseurService.addFournisseur(f);
        System.out.println("Fournisseur Test Delete => "+f);
        FournisseurService.deleteFournisseur(f.getIdFournisseur());
        assertNull(FournisseurService.retrieveFournisseur(f.getIdFournisseur()));
    }

    @Test
    public void retrieveAllFournisseurs()
    {

        List<Fournisseur> fournisseurs= FournisseurService.retrieveAllFournisseurs();
        int expected = fournisseurs.size();
        Fournisseur f= new Fournisseur();
        f.setCode("testRetrieveListFournisseurs");
        f.setLibelle("NNNN");
        f.setCategorieFournisseur(CategorieFournisseur.CONVENTIONNE);
        FournisseurService.addFournisseur(f);
        assertEquals(expected+1, FournisseurService.retrieveAllFournisseurs().size());
    }


    @Test
    public void testUpdateFournisseur()
    {
        Fournisseur f= new Fournisseur();
        f.setCode("testUpdate");
        f.setLibelle("NNNN");
        f.setCategorieFournisseur(CategorieFournisseur.CONVENTIONNE);
        FournisseurService.addFournisseur(f);
        Fournisseur fr= FournisseurService.retrieveFournisseur(f.getIdFournisseur());
        fr.setCategorieFournisseur(CategorieFournisseur.ORDINAIRE);
        FournisseurService.updateFournisseur(fr);
        assertEquals(CategorieFournisseur.ORDINAIRE,fr.getCategorieFournisseur());
        log.info("test update =>" + fr.getCategorieFournisseur());

    }

}
