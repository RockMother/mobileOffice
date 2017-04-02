package generation;

import config.GenerationSettings;
import freemarker.cache.ClassTemplateLoader;
import freemarker.core.ParseException;
import freemarker.template.*;
import model.Database;
import model.Table;

import java.io.*;
import java.util.List;

/**
 * Created by kiril_000 on 22.03.2017.
 */
public class TemplateRunner {
    private final Database model;
    private final GenerationSettings settings;

    public TemplateRunner(Database model, GenerationSettings settings) throws IOException, TemplateException, ParseException, TemplateNotFoundException, MalformedTemplateNameException {
        this.model = model;
        this.settings = settings;
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        ClassTemplateLoader ctl = new ClassTemplateLoader(getClass(), "/templates");
        cfg.setTemplateLoader(ctl);
        Template entityTemplate = cfg.getTemplate("dao/entity.tpl");
        Template mappingTemplate = cfg.getTemplate("dao/mapping.tpl");
        Template repositoryTemplate = cfg.getTemplate("dao/repositoryImpl.tpl");
        Template repositoryInterfaceTemplate = cfg.getTemplate("dao/repository.tpl");
        Template beansDaoTemplate = cfg.getTemplate("initialization/beans.dao.tpl");
        Template hibernateUtilsTemplate = cfg.getTemplate("initialization/hibernateUtils.tpl");
        Template dataServiceImplTemplate = cfg.getTemplate("business/dataServiceImpl.tpl");
        Template dataServiceTemplate = cfg.getTemplate("business/dataService.tpl");
        Template dataServiceBeansTemplate = cfg.getTemplate("business/beans.dataservices.tpl");
        for (Table table: model.getTables()){
            GenerationModel<Table> generationModel = new GenerationModel<Table>(table, settings);
            processTemplateToPackage(entityTemplate, generationModel, settings.getEntityPackageName(), table.getClassName() + ".java");
            processTemplateToResources(mappingTemplate, generationModel, "hibernate\\" + table.getClassName() + ".hbm.xml");
            processTemplateToPackage(repositoryTemplate, generationModel, settings.getRepositoryPackageName(), table.getClassName() + "RepositoryImpl.java");
            processTemplateToPackage(repositoryInterfaceTemplate, generationModel, settings.getRepositoryInterfacePackageName(), table.getClassName() + "Repository.java");

            processTemplateToPackage(dataServiceImplTemplate, generationModel, settings.getDataServicesPackageName(), table.getClassName() + "DataServiceImpl.java");
            processTemplateToPackage(dataServiceTemplate, generationModel, settings.getDataServiceInterfacesPackageName(), table.getClassName() + "DataService.java");

        }

        GenerationModel<List<Table>> generationModel = new GenerationModel<List<Table>>(model.getTables(), settings);
        processTemplateToResources(beansDaoTemplate, generationModel, "beans.dao.xml");
        processTemplateToResources(dataServiceBeansTemplate, generationModel, "beans.dataservices.xml");
        processTemplateToPackage(hibernateUtilsTemplate, generationModel, settings.getUtilsPackageName(), "HibernateUtil.java");
    }


    private void processTemplateToPackage(Template template, GenerationModel model, String packageName, String fileName) throws IOException, TemplateException {
        String root = settings.getProjectRoot();
        String relativePath = packageName.replace(".", "\\");
        processTemplate(template, model, fileName, root + relativePath);
    }

    private void processTemplateToResources(Template template, GenerationModel model, String fileName) throws IOException, TemplateException {
        String root = settings.getResourceRoot();
        processTemplate(template, model, fileName, root);
    }

    private void processTemplate(Template template, GenerationModel model, String fileName, String path) throws IOException, TemplateException {
        File file = new File(path + "\\" + fileName);
        if (file.exists()){
            file.delete();
        }
        file.createNewFile();
        FileOutputStream oFile = new FileOutputStream(file , false);
        Writer out = new OutputStreamWriter(oFile);
        template.process(model, out);
    }
}
