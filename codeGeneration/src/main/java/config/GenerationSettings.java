package config;

/**
 * Created by kisc on 3/23/2017.
 */
public class GenerationSettings {
    private final String projectRoot = "C:\\Projects\\mobileOffice\\mobileOffice\\src\\main\\java\\";
    private final String entityPackageName = "mobileoffice.dao.entities";
    private final String repositoryPackageName = "mobileoffice.dao.repositories";
    private final String repositoryInterfacePackageName = "mobileoffice.dao.contracts";

    public String getProjectRoot() {
        return projectRoot;
    }

    public String getEntityPackageName() {
        return entityPackageName;
    }

    public String getRepositoryPackageName() {
        return repositoryPackageName;
    }

    public String getRepositoryInterfacePackageName() {
        return repositoryInterfacePackageName;
    }
}
