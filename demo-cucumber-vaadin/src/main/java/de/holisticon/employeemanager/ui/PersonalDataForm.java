package de.holisticon.employeemanager.ui;

import com.vaadin.ui.Form;
import com.vaadin.ui.TextField;

@SuppressWarnings("serial")
public class PersonalDataForm extends Form {

	public PersonalDataForm() {
		setCaption("Persönliche Daten");
		setDescription("Zeigt persönliche Daten des eigeloggten Users an");
		addField("another", new TextField("Another Field"));
	}
}
