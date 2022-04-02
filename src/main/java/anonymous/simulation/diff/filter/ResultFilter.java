package anonymous.simulation.diff.filter;

import anonymous.evolution.feature.Variant;
import anonymous.evolution.variability.pc.Artefact;
import anonymous.simulation.diff.components.FineDiff;

import java.nio.file.Path;

public class ResultFilter extends EditFilter {

    public ResultFilter(FineDiff expectedChangesInTarget, Artefact oldTraces, Artefact newTraces, Variant targetVariant, Path oldVersionRoot, Path newVersionRoot, int strip) {
        super(oldTraces, newTraces, targetVariant, oldVersionRoot, newVersionRoot, strip);
    }
}
