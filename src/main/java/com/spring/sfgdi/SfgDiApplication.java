package com.spring.sfgdi;

import com.spring.sfgdi.config.DiConfiguration;
import com.spring.sfgdi.config.DiConstructorConfig;
import com.spring.sfgdi.controllers.*;
import com.spring.sfgdi.datasource.FakeDataSource;
import com.spring.sfgdi.services.PrototypeBean;
import com.spring.sfgdi.services.SingletonBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

//overriding default component Scan
// @ComponentScan(basePackages = {"com.spring.sfgdi", "com.spring.pets"})
//above not needed since we used factory bean and used java config for DI
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

		SingletonBean singletonBean1 = ctx.getBean("singletonBean", SingletonBean.class);
		System.out.println(singletonBean1.getMyScope());
		SingletonBean singletonBean2 = ctx.getBean("singletonBean", SingletonBean.class);
		System.out.println(singletonBean2.getMyScope());

		PrototypeBean prototypeBean1 = ctx.getBean("prototypeBean", PrototypeBean.class);
		System.out.println(prototypeBean1.getMyScope());
		PrototypeBean prototypeBean2 = ctx.getBean("prototypeBean", PrototypeBean.class);
		System.out.println(prototypeBean2.getMyScope());

		System.out.println("------------Fake Data Source");
		FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);
		System.out.println(fakeDataSource.getUsername());
		System.out.println(fakeDataSource.getPassword());
		System.out.println(fakeDataSource.getJdbcURL());

		System.out.println("------------Config Props Bean-- Property Binding");
		DiConfiguration diConfiguration = ctx.getBean(DiConfiguration.class);
		System.out.println(diConfiguration.getUsername());
		System.out.println(diConfiguration.getPassword());
		System.out.println((diConfiguration.getJdbcURL()));

		System.out.println("------------Config Props Bean -- Constructor binding");
		DiConstructorConfig diConstructorConfig = ctx.getBean(DiConstructorConfig.class);
		System.out.println(diConstructorConfig.getUsername());
		System.out.println(diConstructorConfig.getPassword());
		System.out.println(diConstructorConfig.getJdbcURL());

	}

}
