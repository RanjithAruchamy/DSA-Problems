package scaler.function;

public class VolumeOfSphere {

    public static void main(String[] args) {
        assert 5 == solve(1);
        assert 269 == solve(4);
    }

    public static int solve(final int A) {
        double volume = (4 * Math.PI * (A * A * A)) / 3;
        return (int) Math.ceil(volume);
    }
}
