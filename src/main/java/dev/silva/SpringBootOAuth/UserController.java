package dev.silva.SpringBootOAuth;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

@RestController
public class UserController {
    @GetMapping("/")
    public String getUserDetails(Principal principal) {

        OAuth2Authentication oAuth = (OAuth2Authentication) principal;
        boolean isAuthenticated = oAuth.isAuthenticated();

        Map<String, Object> details = (Map<String, Object>)oAuth.getUserAuthentication().getDetails();
        String username = (String)details.get("name");

        return "Username: " + username
                + "<br><br>" +
                "Is User Authenticated? : "+isAuthenticated;

    }


    @GetMapping("/user")
    public Principal showUser(Principal p) {
        System.out.println(p.getClass().getName());
        return p;
    }
}
