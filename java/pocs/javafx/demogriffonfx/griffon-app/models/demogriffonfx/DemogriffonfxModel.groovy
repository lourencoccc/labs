package demogriffonfx

import griffon.core.artifact.GriffonModel
import griffon.transform.FXObservable
import griffon.metadata.ArtifactProviderFor

@ArtifactProviderFor(GriffonModel)
class DemogriffonfxModel {
    @FXObservable String clickCount = "0"
}