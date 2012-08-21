Feature: staff member evaluation view
	
	In order to get information about one's staff member evaluation
	the reports should be available in a dedicated view.
	
	Scenario: As head of staff I have access to all evaluation reports.
		Given I'm head of staff
		When opening the evaluation report view
		Then I have access to the reports of all members
		
	Scenario: As a clerk I have access to my own evaluation report only.
		Given I'm clerk
		When opening the evaluation report view
		Then I have access to my own report only
		
	Scenario: As group leader I have access to all evaluation reports. 
		Given I'm team leader
		When opening the evaluation report view
		Then I have access to the reports of all members

	#Scenario: As group leader I have access to my own report only.
	#	Given I'm team leader
	#	When opening the evaluation report view
	#	Then I have access to the reports of all members
