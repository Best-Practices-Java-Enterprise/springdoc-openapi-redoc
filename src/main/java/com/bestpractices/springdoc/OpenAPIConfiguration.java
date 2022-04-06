package com.bestpractices.springdoc;

import com.bestpractices.springdoc.domain.AppInfo;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfiguration {

    @Bean
    @ConfigurationProperties("application.info")
    public AppInfo createAppInfo() {
        return new AppInfo();
    }


    @Bean
    public OpenAPI createOpenAPI(AppInfo appInfo) {
        Info info = new Info()
                .title(appInfo.getTitle())
                .description(appInfo.getDescription())
                .version(appInfo.getVersion());

        Contact contact = new Contact();
        if(appInfo.getContact()!=null) {
            contact.setName(appInfo.getContact().getName());
            contact.setEmail(appInfo.getContact().getEmail());
            contact.setUrl(appInfo.getContact().getUrl());
        }
        return new OpenAPI().info(info.contact(contact));
    }
}
