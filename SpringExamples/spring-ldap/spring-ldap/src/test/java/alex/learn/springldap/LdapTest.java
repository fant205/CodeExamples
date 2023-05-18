package alex.learn.springldap;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;

import java.util.List;

@SpringBootTest
class LdapTest {
    @Autowired
    private LdapTemplate ldapTemplate;

    @Test
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