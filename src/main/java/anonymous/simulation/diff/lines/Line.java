package anonymous.simulation.diff.lines;

import java.util.Objects;

public abstract class Line {
    private final String line;

    protected Line(final String line) {
        this.line = line;
    }

    public String line() {
        return line;
    }

    @Override
    public String toString() {
        return this.line;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line line1)) return false;
        return Objects.equals(line, line1.line);
    }

    @Override
    public int hashCode() {
        return Objects.hash(line);
    }
}