package generation;

/**
 * Created by kisc on 3/23/2017.
 */
public class GenerationModel<T> {
    T model;
    private String packageName;

    public GenerationModel(T model, String packageName){
        this.model = model;
        this.packageName = packageName;
    }

    public T getModel() {
        return model;
    }

    public String getPackageName() {
        return packageName;
    }
}
