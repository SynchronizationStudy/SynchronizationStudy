package anonymous.evolution.util.names;

@FunctionalInterface
public interface NameGenerator {
    String getNameAtIndex(int i);
}