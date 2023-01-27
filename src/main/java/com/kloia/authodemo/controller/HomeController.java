package com.kloia.authodemo.controller;

import com.kloia.authodemo.client.RestClient;
import com.kloia.authodemo.lookup.Domain;
import com.kloia.authodemo.util.EmailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller for the home page.
 */
@Controller
public class HomeController {

    @Autowired
    private RestClient restClient;

    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal OidcUser principal) {
        if (principal != null) {
            model.addAttribute("profile", principal.getClaims());
            String domain = EmailUtils.getDomain(principal.getAttributes().get("email").toString());
            String response = restClient.get(Domain.findInDomainMap(domain));
            model.addAttribute("companyName", response);
        }
        return "index";
    }
}
