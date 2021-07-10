package com.ganeshkasi.mybankapp;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("com.ganeshkasi.mybankapp");

        noClasses()
            .that()
            .resideInAnyPackage("com.ganeshkasi.mybankapp.service..")
            .or()
            .resideInAnyPackage("com.ganeshkasi.mybankapp.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..com.ganeshkasi.mybankapp.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
