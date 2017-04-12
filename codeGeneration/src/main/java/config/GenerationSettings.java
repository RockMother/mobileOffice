package config;

/**
 * Created by kisc on 3/23/2017.
 */
public class GenerationSettings {
    private final String projectRoot = "D:\\Projects\\mobileOffice\\mobileOffice\\src\\main\\java\\";
    private final String resourceRoot = "D:\\Projects\\mobileOffice\\mobileOffice\\src\\main\\resources\\";
    private final String entityPackageName = "mobileoffice.dao.entities";
    private final String repositoryPackageName = "mobileoffice.dao.repositories";
    private final String repositoryInterfacePackageName = "mobileoffice.dao.contracts";
    private final String utilsPackageName = "mobileoffice.utils";
    private String dataServicesPackageName = "mobileoffice.business.services.data";
    private String dataServiceInterfacesPackageName = "mobileoffice.business.contracts.data";

    public String getProjectRoot() {
        return projectRoot;
    }
    public String getEntityPackageName() {
        return entityPackageName;
    }
    public String getEntityFolder() {
        return entityPackageName.replaceAll("\\.", "/");
    }
    public String getRepositoryPackageName() {
        return repositoryPackageName;
    }
    public String getRepositoryInterfacePackageName() {
        return repositoryInterfacePackageName;
    }
    public String getResourceRoot() {
        return resourceRoot;
    }
    public String getUtilsPackageName() {
        return utilsPackageName;
    }
    public String getDataServicesPackageName() {
        return dataServicesPackageName;
    }
    public String getDataServiceInterfacesPackageName() {
        return dataServiceInterfacesPackageName;
    }
}
