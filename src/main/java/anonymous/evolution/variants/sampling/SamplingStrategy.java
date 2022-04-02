package anonymous.evolution.variants.sampling;

import anonymous.evolution.feature.sampling.Sample;
import anonymous.evolution.variants.blueprints.VariantsRevisionBlueprint;
import de.ovgu.featureide.fm.core.base.IFeatureModel;

import java.util.Optional;

public interface SamplingStrategy {
    Sample sampleForRevision(Optional<IFeatureModel> model, VariantsRevisionBlueprint blueprint);
}
