#Fecha: 17-09-2021
#language: en

@Regresion
Feature: Escenarios que componen la prueba E2E

  @E1
  Scenario: Yo como usuario quiero probar las aplicaciones Desktop, Web y Servicios

    Given Ingreso al portal contactenos
    When Cuando realizo una operacion en la calculadora
