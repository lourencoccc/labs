package tutorial

import griffon.core.artifact.ArtifactManager
import griffon.core.test.GriffonUnitRule
import griffon.core.test.TestFor
import org.junit.Rule
import org.junit.Test

import javax.inject.Inject

import static com.jayway.awaitility.Awaitility.await

@TestFor(GriffonTutorialController)
class GriffonTutorialControllerTest {
    static {
        System.setProperty('org.slf4j.simpleLogger.defaultLogLevel', 'trace')
        // force initialization JavaFX Toolkit
        new javafx.embed.swing.JFXPanel()
    }

    @Inject
    private ArtifactManager artifactManager

    private GriffonTutorialController controller

    @Rule
    public final GriffonUnitRule griffon = new GriffonUnitRule()

    @Test
    void executeClickAction() {
        // given:
        controller.model = artifactManager.newInstance(GriffonTutorialModel)

        // when:
        controller.invokeAction('click')
        await().until { controller.model.clickCount != "0" }

        // then:
        assert "1" == controller.model.clickCount
    }
}
