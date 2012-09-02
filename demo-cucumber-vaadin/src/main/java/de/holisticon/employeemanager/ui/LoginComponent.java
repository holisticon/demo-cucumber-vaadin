package de.holisticon.employeemanager.ui;


import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.LoginForm;
import com.vaadin.ui.LoginForm.LoginEvent;
import com.vaadin.ui.LoginForm.LoginListener;

import de.holisticon.demo.ApplicationEventBus;

@SuppressWarnings("serial")
public class LoginComponent extends CustomComponent {

	@AutoGenerated
	private GridLayout mainLayout;
	@AutoGenerated
	private LoginForm loginForm_1;

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public LoginComponent() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		// TODO add user code here
		postLoginEvents();
	}

	private void postLoginEvents() {
		loginForm_1.addListener(new LoginListener() {
			
			public void onLogin(LoginEvent event) {
				ApplicationEventBus.post(event);
			}
		});
	}

	@AutoGenerated
	private GridLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new GridLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");
		mainLayout.setMargin(false);
		mainLayout.setColumns(3);
		mainLayout.setRows(3);
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("100.0%");
		
		// loginForm_1
		loginForm_1 = new LoginForm();
		loginForm_1.setStyleName("v-loginform");
		loginForm_1.setImmediate(false);
		loginForm_1.setWidth("-1px");
		loginForm_1.setHeight("-1px");
		mainLayout.addComponent(loginForm_1, 1, 1);
		mainLayout.setComponentAlignment(loginForm_1, new Alignment(48));
		
		return mainLayout;
	}

}
