import java.util.function.Predicate;

public class IsGreaterThan implements Predicate<Integer> {
    public final int threshold;

    public IsGreaterThan(final int threshod) {
        this.threshold = threshod;
    }

    @Override
    public boolean test(Integer t) {
        return t > threshold;
    }

}