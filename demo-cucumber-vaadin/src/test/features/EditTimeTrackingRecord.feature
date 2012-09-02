Feature: Tracking Time

	As an user I want to track working times in order not to forget it.
	
	Scenario: Tracking a working time
		Given I'm an employee with username 'roland' and password 'juelich'
		When I record an entry for 'talk at herbstcampus' on '06.09.2012' from '15:40' to '16:50'
		Then the saved record is displayed
			| 06.09.2012 | 15:40 | 16:50 | talk at herbstcampus |
			

	Scenario: Login failure for unknown user
		Given I'm an employee with username 'roland' and password 'vergessen'
		Then login is denied
		
	