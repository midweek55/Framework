#Fecha: 17-09-2021
#language: en

@Regresion
Feature: Escenarios que componen la prueba E2E

  @E1
  Scenario: Yo como usuario quiero inicar un proyecto

    Given Ingreso al portal contactenos
    Then Escribo el correo electronico en iniciar proyecto
    Then Escribo el telefono
    Then Escribo el Nombre Completo
    Then Escribo la Organizacion
    Then Selecciono un pais
    Then Escribo una ciudad
    Then Escribo una prueba
    Then Seleciono un servicio de interes
    Then Seleciono un producto de interes
    Then Escribo un comentario