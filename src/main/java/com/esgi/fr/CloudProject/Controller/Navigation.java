package com.esgi.fr.CloudProject.Controller;

import com.vaadin.navigator.Navigator;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;

public class Navigation {
	
	private Navigator n;
	private Button login;
	
	
	
	public Button getLoginButton (Component c) {
		login = new Button("Login");
		
		login.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				n = event.getButton().getUI().getNavigator();
				n.getUI().getUI().setContent(c);
			}
		});
		return login;
	}
}
