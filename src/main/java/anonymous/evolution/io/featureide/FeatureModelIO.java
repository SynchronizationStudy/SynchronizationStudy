package anonymous.evolution.io.featureide;

import anonymous.evolution.io.ResourceLoader;
import anonymous.evolution.io.ResourceWriter;
import anonymous.evolution.util.fide.ProblemListUtils;
import anonymous.evolution.util.functional.Result;
import anonymous.evolution.util.functional.Unit;
import anonymous.evolution.util.io.PathUtils;
import de.ovgu.featureide.fm.core.base.IFeatureModel;
import de.ovgu.featureide.fm.core.base.impl.DefaultFeatureModelFactory;
import de.ovgu.featureide.fm.core.io.IFeatureModelFormat;
import de.ovgu.featureide.fm.core.io.ProblemList;
import de.ovgu.featureide.fm.core.io.manager.SimpleFileHandler;

import java.nio.file.Files;
import java.nio.file.Path;

public class FeatureModelIO implements ResourceLoader<IFeatureModel>, ResourceWriter<IFeatureModel> {
    private final IFeatureModelFormat format;

    public FeatureModelIO(final IFeatureModelFormat format) {
        this.format = format;
    }

    @Override
    public boolean canLoad(final Path p) {
        return format.supportsRead() && PathUtils.hasExtension(p, format.getSuffix());
    }

    @Override
    public boolean canWrite(final Path p) {
        return format.supportsWrite() && PathUtils.hasExtension(p, format.getSuffix());
    }

    @Override
    public Result<IFeatureModel, ? extends Exception> load(final Path p) {
        final IFeatureModel featureModel = DefaultFeatureModelFactory.getInstance().create();
        return Result
                .<ProblemList, Exception>Try(() -> format.read(featureModel, Files.readString(p)))
                .bind(problemList -> ProblemListUtils.toResult(
                        problemList,
                        () -> featureModel,
                        () -> "Could not load feature model " + p + ".")
                );
    }

    @Override
    public Result<Unit, ? extends Exception> write(final IFeatureModel model, final Path p) {
        return ProblemListUtils.toResult(
                SimpleFileHandler.save(p, model, format),
                Unit::Instance,
                () -> "Could not write feature model " + model.toString() + " to " + p
        );
    }
}
