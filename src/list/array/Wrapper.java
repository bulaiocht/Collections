package list.array;

/**
 *
 * Created by Kocherha Vitalii on 12.06.16.
 */
public class Wrapper <T> {

    private T parameter;

    public Wrapper(T parameter) {
        this.parameter = parameter;
    }

    public T getParameter() {
        return parameter;
    }

    public void setParameter(T parameter) {
        this.parameter = parameter;
    }
}
