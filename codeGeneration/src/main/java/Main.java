import config.ConnectionSettings;
import config.GenerationSettings;
import db.ModelExtractor;
import generation.TemplateRunner;

/**
 * Created by kiril_000 on 22.03.2017.
 */
public class Main {
    public static void main(String[] args) {
        ModelExtractor modelExtractor = new ModelExtractor(new ConnectionSettings());
        try {
            TemplateRunner runner = new TemplateRunner(modelExtractor.extractModel(), new GenerationSettings());
        }
        catch (Exception ex){

        }
    }
}
