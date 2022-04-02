package anonymous.evolution.variability.pc.visitor;

import anonymous.evolution.variability.pc.LineBasedAnnotation;

public class LineBasedAnnotationVisitorFocus extends ArtefactTreeVisitorFocus<LineBasedAnnotation> {
    public LineBasedAnnotationVisitorFocus(final LineBasedAnnotation artefact) {
        super(artefact);
    }

    @Override
    public void accept(final ArtefactVisitor visitor) {
        visitor.visitLineBasedAnnotation(this);
    }
}
