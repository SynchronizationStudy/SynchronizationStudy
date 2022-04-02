package anonymous.evolution.variability.pc.groundtruth;

import anonymous.evolution.variability.pc.LineBasedAnnotation;

public record AnnotationGroundTruth(
        LineBasedAnnotation splArtefact,
        LineBasedAnnotation variantArtefact,
        BlockMatching matching
)
{
}
