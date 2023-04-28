package alex.learn.springldap.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

@Configuration
public class Config {
    @Bean
    public LdapContextSource contextSource() {
        LdapContextSource contextSource = new LdapContextSource();

//        contextSource.setUrl("ldap://10.2.96.233:18889");
        contextSource.setUrl("ldap://10.2.96.233:636");
        contextSource.setBase("dc=free.dmz");
        contextSource.setUserDn("uer_user");
        contextSource.setPassword("One-leg-horse");

        return contextSource;
    }

    @Bean
    public LdapTemplate ldapTemplate() {
        return new LdapTemplate(contextSource());
    }

}