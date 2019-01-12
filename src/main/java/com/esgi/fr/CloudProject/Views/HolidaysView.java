package com.esgi.fr.CloudProject.Views;

import com.vaadin.navigator.View;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class HolidaysView extends CssLayout implements View{
	
	private DateField begin;
	private DateField ending;
	private Button submit;
	
	
	
	public HolidaysView() {
		begin = new DateField("Début");
		ending = new DateField("Retour le");
		submit = new Button("Soumettre");
		buildUI();
    	setSizeFull();

	}

	private void buildUI() {
		addStyleName("login-screen");
		Component form = buildHolidayForm();
		VerticalLayout centeringLayout = new VerticalLayout();
		//	        centeringLayout.setMargin(false);
		//	        centeringLayout.setSpacing(false);
		centeringLayout.setStyleName("center");
		centeringLayout.addComponent(form);
		centeringLayout.setComponentAlignment(form,Alignment.BOTTOM_CENTER);
		addComponent(centeringLayout);
		
	}

	private Component buildHolidayForm() {

		FormLayout holiday = new FormLayout();
		
		holiday.addComponent(begin);
		begin.setWidth(15, Unit.EM);
		holiday.addComponent(ending);
		ending.setWidth(15, Unit.EM);
		CssLayout buttons = new CssLayout();
		buttons.setStyleName("buttons");
		holiday.addComponent(buttons);
		buttons.addComponent(submit);
		submit.addStyleName(ValoTheme.BUTTON_FRIENDLY);
		return holiday;
	}


}
