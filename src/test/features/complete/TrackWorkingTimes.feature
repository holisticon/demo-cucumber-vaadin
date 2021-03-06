Feature: Track Working Times

	As an employee
	I want to track my working times
	In order to provide it for salary calculation 
	
	Background:
		Given known credentials 'roland' 'juelich'
		And I login with username 'roland' and password 'juelich'
	
	Scenario: valid working times
		When I record an entry for talk at herbstcampus on 06.09.2012 from 15:40 to 16:50
		Then a notification 'your record has been saved' appears
		And the saved record is displayed
			| 06.09.2012 | 15:40 | 16:50 | talk at herbstcampus |
	
	Scenario Outline: invalid working times
		When I record an entry for <Activity> on <Date> from <From> to <Until>
		Then form displays validation error <ErrorMessage>
		
			Examples:
			| Date 			| From	| Until | Activity 					| ErrorMessage						|
			| 06.09.2012	| 16:50	| 15:40	| talk at herbstcampus		| Startzeit muss vor Endzeit liegen	|
			
		
				
	
