package generation;

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
    public TemplateRunner(Database model) throws IOException, TemplateException {
        Configuration cfg = new Configuration();
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setDirectoryForTemplateLoading(new File(
                "D:\\Projects\\mobileOffice\\codeGeneration\\codeGeneration\\src\\main\\java\\generation\\templates"));

        for (Table table: model.getTables()){
            Template entityTemplate = cfg.getTemplate("entity.tpl");
            Template mappingTemplate = cfg.getTemplate("mapping.tpl");
            processTemplate(entityTemplate, table, table.getClassName() + ".java");
            processTemplate(mappingTemplate, table, table.getClassName() + ".hbm.xml");
        }
    }

    private <T> void processTemplate(Template template, T model, String fileName) throws IOException, TemplateException {

        File file = new File("D:\\temp\\" + fileName);
        file.getParentFile().mkdirs();
        if (file.exists()){
            file.delete();
        }
        file.createNewFile();
        FileOutputStream oFile = new FileOutputStream(file , false);
        Writer out = new OutputStreamWriter(oFile);
        template.process(model, out);
    }
}
