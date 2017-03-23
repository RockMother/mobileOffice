import config.ConnectionSettings;
import config.GenerationSettings;
import db.ModelExtractor;
import freemarker.template.TemplateException;
import generation.TemplateRunner;

import java.io.IOException;

/**
 * Created by kiril_000 on 22.03.2017.
 */
public class Main {
    public static void main(String[] args) throws IOException, TemplateException {
        ModelExtractor modelExtractor = new ModelExtractor(new ConnectionSettings());
        TemplateRunner runner = new TemplateRunner(modelExtractor.extractModel(), new GenerationSettings());
    }
}
