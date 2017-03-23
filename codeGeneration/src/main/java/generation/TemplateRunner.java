package generation;

import config.GenerationSettings;
import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import model.Database;
import model.Table;

import java.io.*;

/**
 * Created by kiril_000 on 22.03.2017.
 */
public class TemplateRunner {
    private final Database model;
    private final GenerationSettings settings;

    public TemplateRunner(Database model, GenerationSettings settings) throws IOException, TemplateException {
        this.model = model;
        this.settings = settings;
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        ClassTemplateLoader ctl = new ClassTemplateLoader(getClass(), "/templates");
        cfg.setTemplateLoader(ctl);
        for (Table table: model.getTables()){
            GenerationModel<Table> generationModel = new GenerationModel<Table>(table, settings.getEntityPackageName());
            Template entityTemplate = cfg.getTemplate("entity.tpl");
            Template mappingTemplate = cfg.getTemplate("mapping.tpl");
            processTemplate(entityTemplate, generationModel, table.getClassName() + ".java");
            processTemplate(mappingTemplate, generationModel, table.getClassName() + ".hbm.xml");
        }
    }

    private <T> void processTemplate(Template template, T model, String fileName) throws IOException, TemplateException {

        String root = settings.getProjectRoot();
        String relativePath = settings.getEntityPackageName().replace(".", "\\");
        File file = new File(root + relativePath + "\\" + fileName);
        //file.getParentFile().mkdirs();
        if (file.exists()){
            file.delete();
        }
        file.createNewFile();
        FileOutputStream oFile = new FileOutputStream(file , false);
        Writer out = new OutputStreamWriter(oFile);
        template.process(model, out);
    }
}
