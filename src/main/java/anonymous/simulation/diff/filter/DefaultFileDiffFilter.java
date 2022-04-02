package anonymous.simulation.diff.filter;

import anonymous.simulation.diff.components.FileDiff;

public class DefaultFileDiffFilter implements IFileDiffFilter {

    @Override
    public boolean shouldKeep(final FileDiff fileDiff) {
        return true;
    }
}