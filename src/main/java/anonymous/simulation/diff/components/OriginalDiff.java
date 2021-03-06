package anonymous.simulation.diff.components;

import java.util.LinkedList;
import java.util.List;

public record OriginalDiff(List<FileDiff> fileDiffs) implements IDiffComponent {
    @Override
    public List<String> toLines() {
        final List<String> lines = new LinkedList<>();
        fileDiffs.stream().map(IDiffComponent::toLines).forEach(lines::addAll);
        return lines;
    }

    public boolean isEmpty() {
        return this.fileDiffs.isEmpty();
    }
}