package com.camelatwork.components.http4.properties;

/**
 * Created by marcomaccio on 14/12/2015.
 */
public class MyRouteProperties {

    private String  rmsHost;
    private String  rmsPort;
    private String  rmsContext;
    private String  rmsServicesPath;
    private String  rmsServiceMethod;
    private String  rmsContentsPath;
    private String  rmsRepository;

    public String getRmsHost() {
        return rmsHost;
    }

    public void setRmsHost(String rmsHost) {
        this.rmsHost = rmsHost;
    }

    public String getRmsPort() {
        return rmsPort;
    }

    public void setRmsPort(String rmsPort) {
        this.rmsPort = rmsPort;
    }

    public String getRmsContext() {
        return rmsContext;
    }

    public void setRmsContext(String rmsContext) {
        this.rmsContext = rmsContext;
    }

    public String getRmsServicesPath() {
        return rmsServicesPath;
    }

    public void setRmsServicesPath(String rmsServicesPath) {
        this.rmsServicesPath = rmsServicesPath;
    }

    public String getRmsContentsPath() {
        return rmsContentsPath;
    }

    public void setRmsContentsPath(String rmsContentsPath) {
        this.rmsContentsPath = rmsContentsPath;
    }

    public String getRmsServiceMethod() {
        return rmsServiceMethod;
    }

    public void setRmsServiceMethod(String rmsServiceMethod) {
        this.rmsServiceMethod = rmsServiceMethod;
    }

    public String getRmsRepository() {
        return rmsRepository;
    }

    public void setRmsRepository(String rmsRepository) {
        this.rmsRepository = rmsRepository;
    }
}
