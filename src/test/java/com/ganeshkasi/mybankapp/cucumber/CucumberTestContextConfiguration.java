package com.ganeshkasi.mybankapp.cucumber;

import com.ganeshkasi.mybankapp.JhipsterBankApplicationApp;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = JhipsterBankApplicationApp.class)
@WebAppConfiguration
public class CucumberTestContextConfiguration {}
