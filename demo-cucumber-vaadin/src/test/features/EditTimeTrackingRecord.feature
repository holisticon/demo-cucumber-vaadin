Feature: Tracking Time

	As an user I want to track working times in order not to forget it.
	
	Scenario: Tracking a working time
		Given I'm an employee with username 'willi' and password 'winzig'
		When I record an entry for 'visit @OTTO' on '27.08.2012' from '11:00' to '12:00'
		Then the record is saved 
	
	
