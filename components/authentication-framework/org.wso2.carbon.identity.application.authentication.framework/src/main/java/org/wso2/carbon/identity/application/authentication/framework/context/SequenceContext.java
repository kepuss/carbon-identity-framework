package org.wso2.carbon.identity.application.authentication.framework.context;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SequenceContext {

    private int currentStepCount = 1;

    private RequestPathAuthenticatorContext requestPathAuthenticatorContext = null;
    private List<StepContext> stepContextList = new ArrayList<>();

    public SequenceContext() {

    }

    public RequestPathAuthenticatorContext getRequestPathAuthenticator() {
        return requestPathAuthenticatorContext;
    }

    public void setRequestPathAuthenticator(
            RequestPathAuthenticatorContext requestPathAuthenticatorContext) {
        this.requestPathAuthenticatorContext = requestPathAuthenticatorContext;
    }

    public int getCurrentStepCount() {
        return currentStepCount;
    }

    public void setCurrentStepCount(int currentStepCount) {
        this.currentStepCount = currentStepCount;
    }

    public StepContext getCurrentStepContext() {
        StepContext stepAuthenticatorsContext = null;
        if (stepContextList.size() >= currentStepCount) {
            stepAuthenticatorsContext = stepContextList.get(stepContextList.size());
        }
        return stepAuthenticatorsContext;
    }

    public void addCurrentStepAuthenticatorContext(StepContext stepContext) {
        stepContextList.add(stepContext);
    }


    public static class RequestPathAuthenticatorContext {
        private boolean isAuthenticated = false;

        public boolean isAuthenticated() {
            return isAuthenticated;
        }

        public void setIsAuthenticated(boolean isAuthenticated) {
            this.isAuthenticated = isAuthenticated;
        }
    }

    public static class StepContext {
        private int step;
        private String name ;
        private User user;
        private boolean isAuthenticated = false;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isAuthenticated() {
            return isAuthenticated;
        }

        public void setIsAuthenticated(boolean isAuthenticated) {
            this.isAuthenticated = isAuthenticated;
        }

        public int getStep() {
            return step;
        }

        public void setStep(int step) {
            this.step = step;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }
    }

    public static class User implements Serializable {
        private String userIdentifier;


        public String getUserIdentifier() {
            return userIdentifier;
        }

        public void setUserIdentifier(String userIdentifier) {
            this.userIdentifier = userIdentifier;
        }

    }

    public class FederatedUser extends User {

    }

    public static class LocalUser extends User {

        private String tenantDomain;
        private String userStoreDomain;
        private String userName;

        public String getTenantDomain() {
            return tenantDomain;
        }

        public void setTenantDomain(String tenantDomain) {
            this.tenantDomain = tenantDomain;
        }

        public String getUserStoreDomain() {
            return userStoreDomain;
        }

        public void setUserStoreDomain(String userStoreDomain) {
            this.userStoreDomain = userStoreDomain;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }


}
