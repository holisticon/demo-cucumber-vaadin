# language: de

Funktionalität: Anzeige von Mitarbeiterbewertungen
	
	Um sicher über die Bewertungen von Mitarbeitern zu informieren, 
	müssen die Berichte anzeigbar sein.
	
	Szenario: Als Vorstandsvorsitzender kann ich alle Bewertungen sehen.
		Angenommen ich bin Vorstandsvorsitzender
		Wenn ich die Ansicht für Berichte öffne
		Dann kann ich die Bewertungen aller Mitarbeiter einsehen
		
	Szenario: Als Sachbearbeiter kann ich nur meine eigenen Bewertungen sehen.
		Angenommen ich bin Sachbearbeiter
		Wenn ich die Ansicht für Berichte öffne
		Dann kann ich nur meine eigenen Bewertungen einsehen
		
	Szenario: Als Teamleiter kann ich die Bewertungen aller Teammitglieder sehen.
		Angenommen ich bin Teamleiter
		Wenn ich die Ansicht für Berichte öffne
		Dann kann ich die Bewertungen aller Teammitglieder einsehen
		
	#Szenario: Als Teamleiter kann ich nur meine eigenen Bewertungen sehen.
	#	Angenommen ich bin Teamleiter
	#	Wenn ich die Ansicht für Berichte öffne
	#	Dann kann ich nur meine eigenen Bewertungen einsehen