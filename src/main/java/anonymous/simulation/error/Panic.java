package anonymous.simulation.error;

public class Panic extends Error {
    public Panic(final String message) {
        super(message);
    }

    public Panic() {
        super();
    }
}
