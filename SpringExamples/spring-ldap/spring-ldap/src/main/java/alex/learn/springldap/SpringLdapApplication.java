package alex.learn.springldap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;

import java.util.List;

@SpringBootApplication
public class SpringLdapApplication implements CommandLineRunner {
    @Autowired
    private LdapTemplate ldapTemplate;

    public static void main(String[] args) {
        SpringApplication.run(SpringLdapApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("Hi hi");
        ldap();
    }

    void ldap() {
        List<String> uerUser = search("uer_user");
        System.out.println(uerUser.toString());
    }

    public List<String> search(String username) {
        return ldapTemplate
                .search(
                        "ou=users",
                        "cn=" + username,
                        (AttributesMapper<String>) attrs -> (String) attrs.get("cn").get());
    }

}