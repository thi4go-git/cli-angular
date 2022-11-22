package br.com.angular.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.util.Locale;

@Configuration
public class MessagesConfig {

    @Bean
    public MessageSource menssageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("ISO-8859-1");
        messageSource.setDefaultLocale(Locale.getDefault());
        return messageSource;
    }

    @Bean// esse bean fará a validação de acordo com o método menssageSource()
    public LocalValidatorFactoryBean localValidatorFactoryBean() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(menssageSource());
        return bean;
    }


}
