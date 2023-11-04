package com.esprit.examen.services;

import com.esprit.examen.entities.Operateur;
import com.esprit.examen.repositories.OperateurRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class OperateurServiceImplTest {
    private OperateurRepository operateurRepository =  Mockito.mock(OperateurRepository.class);;

    @InjectMocks
    private OperateurServiceImpl operateurService ;
    @Autowired
            private OperateurRepository junitOperRepo;
    @Autowired
            private IOperateurService junitOperService;

    List<Operateur> operateurslist = new ArrayList() {
        {
            add(
                    Operateur.builder()
                            .idOperateur(555L)
                            .nom("khouloud")
                            .password("khouloud")
                            .prenom("ben mbarek")
                            .build()

            );
        }};

        @Test
        void retrieveAllOperateurs() {

            Mockito.when(operateurRepository.findAll()).thenReturn(operateurslist);
            List<Operateur> operateurslist = operateurService.retrieveAllOperateurs();
            assertFalse(operateurslist.isEmpty());
            verify(operateurRepository).findAll();
        }

    @Test
    void addOperateur() {
            Operateur newOperateur = Operateur.builder()
                    .nom("khouloud")
                    .prenom("ben mbarek")
                    .password("hello")
                    .build();
            Operateur responseOperateur = this.junitOperService.addOperateur(newOperateur);
            assertNotNull(responseOperateur);
            assertEquals(newOperateur.getNom(),responseOperateur.getNom());
            this.junitOperService.deleteOperateur(responseOperateur.getIdOperateur());

    }

        @Test
        void deleteOperateur() {
        }

        @Test
        void updateOperateur() {
        }

        @Test
        void retrieveOperateur() {
        }
    }