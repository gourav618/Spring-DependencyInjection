package com.spring.sfgdi.config;

//java based config example

import com.spring.pets.PetService;
import com.spring.pets.PetServiceFactory;
import com.spring.sfgdi.datasource.FakeDataSource;
import com.spring.sfgdi.repositories.EnglishGreetingRepository;
import com.spring.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import com.spring.sfgdi.services.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;

@EnableConfigurationProperties(DiConstructorConfig.class)
//NOTE: in spring boot we can have our own var in app.prop so datasource.prop deleted
//@PropertySource("classpath:datasource.properties") --> annotation from spring framework
//import resources from xml configuration
@ImportResource("classpath:di-config.xml")
@Configuration
public class GreetingServiceConfig {

    @Bean
    FakeDataSource fakeDataSource(DiConfiguration diConfiguration){
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(diConfiguration.getUsername());
        fakeDataSource.setPassword(diConfiguration.getPassword());
        fakeDataSource.setJdbcURL(diConfiguration.getJdbcURL());
        return fakeDataSource;
    }


    @Bean
    PetServiceFactory petServiceFactory(){
        return new PetServiceFactory();
    }

    @Profile({"dog","default"})
    @Bean
    PetService dogPetService(){
        return petServiceFactory().getPetService("dog");
    }

    @Profile("cat")
    @Bean
    PetService catPetService(){
        return petServiceFactory().getPetService("cat");
    }

    //beans are created here for the greeting services and bean name by default is method name
    //Note: @Service anotation removed from these classes and bean are init here

    //note commented since this bean declared using xml configuration
    //@Bean
//    ConstructorGreetingService constructorGreetingService(){
//        return new ConstructorGreetingService();
//    }

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService(){
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService(){
        return new SetterInjectedGreetingService();
    }

    //setting bean as primary
    @Primary
    @Bean
    PrimaryInjectedGreetingService primaryInjectedGreetingService(){
        return new PrimaryInjectedGreetingService();
    }

    //java config has use DI to use this in eng greeting service
    @Bean
    EnglishGreetingRepository englishGreetingRepository(){
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile("EN")
    @Bean
    I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository){
        return new I18nEnglishGreetingService(englishGreetingRepository);
    }

    @Profile({"ES","default"})
    @Bean("i18nService")
    I18nSpanishGreetingService i18nSpanishGreetingService(){
        return new I18nSpanishGreetingService();
    }
}
