/*
 * Copyright 2009 IT Mill Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package de.holisticon.emapp;


import com.vaadin.Application;
import com.vaadin.ui.Window;

import de.holisticon.emapp.handler.LoginHandler;
import de.holisticon.emapp.handler.LogoutHandler;
import de.holisticon.emapp.ui.LoginComponent;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class EmployeeManagerApp extends Application
{
    private Window window;
    
    @Override
    public void init()
    {

    	ApplicationEventBus.register(new LoginHandler(this));
    	ApplicationEventBus.register(new LogoutHandler(this));
    	
        window = new Window("My Vaadin Application");
        setMainWindow(window);

        window.setContent(new LoginComponent());
    }

	public void logout() {
		window.setContent(new LoginComponent());
		close();
//		((WebApplicationContext)getContext()).getHttpSession().invalidate();
	}
    
}
