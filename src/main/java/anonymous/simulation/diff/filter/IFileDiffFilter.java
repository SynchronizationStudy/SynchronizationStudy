package anonymous.simulation.diff.filter;

import anonymous.simulation.diff.components.FileDiff;

public interface IFileDiffFilter {
    boolean shouldKeep(FileDiff fileDiff);
}