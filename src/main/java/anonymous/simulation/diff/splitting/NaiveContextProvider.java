package anonymous.simulation.diff.splitting;

import anonymous.simulation.diff.filter.ILineFilter;
import anonymous.simulation.diff.components.FileDiff;
import anonymous.simulation.diff.lines.Line;

import java.nio.file.Path;
import java.util.List;

public class NaiveContextProvider extends DefaultContextProvider {
    public NaiveContextProvider(final Path rootDir) {
        super(rootDir);
    }

    public NaiveContextProvider(final Path rootDir, final int contextSize) {
        super(rootDir, contextSize);
    }

    @Override
    public List<Line> leadingContext(final ILineFilter lineFilter, final FileDiff fileDiff, final int index) {
        return super.leadingContext((p, i) -> true, fileDiff, index);
    }

    @Override
    public List<Line> trailingContext(final ILineFilter lineFilter, final FileDiff fileDiff, final int index) {
        return super.trailingContext((p, i) -> true, fileDiff, index);
    }
}
