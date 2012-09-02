Feature: Authentication and Login

	As an employee 
	I want login to the employee management application 
	In manage my company related data
	
	Scenario: unknown users cannot login
		Given I'm an employee with username 'roland' and password 'vergessen'
		Then login is denied
		
	
