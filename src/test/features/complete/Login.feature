Feature: Login

	As an user of employee management application 
	I want to login into the application
	In order to edit personal information 
	
	Scenario: login as a known user
		Given known credentials 'roland' 'juelich'
		When I login with username 'roland' and password 'juelich'
		Then I get access to the editor.

	Scenario: login as a unknown user
		Given unknown credentials 'anonymous' 'guess'
		When I login with username 'anonymous' and password 'guess'
		Then the login is denied
		And it displays an error message 'unbekannter user'

	
