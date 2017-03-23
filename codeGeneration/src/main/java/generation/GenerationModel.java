package generation;

import config.GenerationSettings;

/**
 * Created by kisc on 3/23/2017.
 */
public class GenerationModel<T> {
    T model;
    private GenerationSettings settings;

    public GenerationModel(T model, GenerationSettings settings){
        this.model = model;
        this.settings = settings;
    }

    public T getModel() {
        return model;
    }

    public GenerationSettings getSettings() {
        return settings;
    }
}
