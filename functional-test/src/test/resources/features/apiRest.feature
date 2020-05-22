Feature: BackEnd Service

  Scenario: Get Petition
    Given the service: https://www.google.com
    When the user does a GET petition
    Then the response is 200