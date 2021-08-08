package com.spring.sfgdi;

import com.spring.sfgdi.controllers.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//overriding default component Scan
@ComponentScan(basePackages = {"com.spring.sfgdi", "com.spring.pets"})
@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		PetController petController = ctx.getBean("petController",PetController.class);
		System.out.println("----The Best Pet IS -------");
		System.out.println(petController.whichPetIsTheBest());

		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.println("-----------Using Spring Profile");
		System.out.println(i18nController.sayHello());

		//Spring is creating Object for this(MyController) and we are naming that bean as myController
		MyController myController = (MyController) ctx.getBean("myController");

		System.out.println("-----------Primary Bean");
		System.out.println(myController.sayHello());

		//common mistake when using Spring for di
		//Note the controller class should be @Controller to set this Bean and Service Object @AutoWired else we would get NPE
		System.out.println("---------Property");
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("---------Setter");
		SetterInjectedController setterInjectedController =(SetterInjectedController) ctx.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());

		System.out.println("---------Constructor");
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());
	}

}
