package anonymous.evolution;

import anonymous.evolution.feature.sampling.ConstSampler;
import anonymous.evolution.feature.sampling.FeatureIDESampler;
import anonymous.evolution.io.Resources;
import anonymous.evolution.io.data.VariabilityDatasetLoader;
import anonymous.evolution.repository.AbstractSPLRepository;
import anonymous.evolution.util.Logger;
import anonymous.evolution.util.functional.Functional;
import anonymous.evolution.util.functional.Lazy;
import anonymous.evolution.util.functional.MonadTransformer;
import anonymous.evolution.util.functional.Unit;
import anonymous.evolution.util.list.NonEmptyList;
import anonymous.evolution.variability.EvolutionStep;
import anonymous.evolution.variability.SPLCommit;
import anonymous.evolution.variability.VariabilityDataset;
import anonymous.evolution.variability.VariabilityHistory;
import anonymous.evolution.variability.sequenceextraction.LongestNonOverlappingSequences;
import anonymous.evolution.variants.VariantsRepository;
import anonymous.evolution.variants.VariantsRevision;
import anonymous.evolution.variants.sampling.SampleOnceAtBeginStrategy;
import anonymous.evolution.variants.sampling.SamplingStrategy;
import de.ovgu.featureide.fm.core.base.impl.*;
import de.ovgu.featureide.fm.core.configuration.*;
import de.ovgu.featureide.fm.core.io.sxfm.SXFMFormat;
import de.ovgu.featureide.fm.core.io.xml.XmlFeatureModelFormat;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.Properties;
import java.util.Set;

public class Main {
    private static final File PROPERTIES_FILE = new File("src/main/resources/user.properties");
    private static final String VARIABILITY_DATASET = "variability_dataset";
    private static final String SPL_REPO = "spl_repo";
    private static final String VARIANTS_REPO = "variants_repo";
    private static boolean initialized = false;

    private static void InitFeatureIDE() {
        /*
         * Who needs an SPL if we can clone-and-own from FeatureIDE's FMCoreLibrary, lol.
         */

        FMFactoryManager.getInstance().addExtension(DefaultFeatureModelFactory.getInstance());
        FMFactoryManager.getInstance().addExtension(MultiFeatureModelFactory.getInstance());
        FMFactoryManager.getInstance().setWorkspaceLoader(new CoreFactoryWorkspaceLoader());

        FMFormatManager.getInstance().addExtension(new XmlFeatureModelFormat());
        FMFormatManager.getInstance().addExtension(new SXFMFormat());

        ConfigurationFactoryManager.getInstance().addExtension(DefaultConfigurationFactory.getInstance());
        ConfigurationFactoryManager.getInstance().setWorkspaceLoader(new CoreFactoryWorkspaceLoader());

        ConfigFormatManager.getInstance().addExtension(new XMLConfFormat());
        ConfigFormatManager.getInstance().addExtension(new DefaultFormat());
        ConfigFormatManager.getInstance().addExtension(new FeatureIDEFormat());
        ConfigFormatManager.getInstance().addExtension(new EquationFormat());
        ConfigFormatManager.getInstance().addExtension(new ExpressionFormat());
    }

    public static void Initialize() {
        if (!initialized) {
            Logger.initConsoleLogger();
            InitFeatureIDE();
            initialized = true;
            Logger.debug("Finished initialization");
        }
    }

    public static void main(final String[] args) throws IOException, Resources.ResourceIOException {
        Initialize();
    }
}