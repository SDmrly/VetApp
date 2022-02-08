package com.App.Vet.business.abstracts;

import org.springframework.security.core.Authentication;

public interface AuthenticationService {
    Authentication getAuthentication();
    String getCurrentUserName();
    int getCurrentUserId();
}
