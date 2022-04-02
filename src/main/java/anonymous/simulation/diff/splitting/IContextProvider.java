package anonymous.simulation.diff.splitting;

import anonymous.simulation.diff.components.FileDiff;
import anonymous.simulation.diff.filter.ILineFilter;
import anonymous.simulation.diff.lines.Line;

import java.util.List;

public interface IContextProvider {
    List<Line> leadingContext(ILineFilter lineFilter, FileDiff fileDiff, int index);

    List<Line> trailingContext(ILineFilter lineFilter, FileDiff fileDiff, int index);
}