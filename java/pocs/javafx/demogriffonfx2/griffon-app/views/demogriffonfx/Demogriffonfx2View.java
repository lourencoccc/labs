package demogriffonfx;

import griffon.core.artifact.GriffonView;
import griffon.metadata.ArtifactProviderFor;
//import javafx.fxml.FXML;
//import javafx.scene.Group;
//import javafx.scene.Node;
import javafx.scene.Scene;
//import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
//import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.codehaus.griffon.runtime.javafx.artifact.AbstractJavaFXGriffonView;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.Map;

@ArtifactProviderFor(GriffonView.class)
public class Demogriffonfx2View extends AbstractJavaFXGriffonView {
    private TabPane tabPane;

    @Nonnull
    public TabPane getTabPane() {
        return tabPane;
    }

    @Override
    public void mvcGroupInit(@Nonnull Map<String, Object> args) {
        createMVCGroup("tab1");
        createMVCGroup("tab2");
        createMVCGroup("tab3");
        createMVCGroup("tab4");
    }

    @Override
    public void initUI() {
        Stage stage = (Stage) getApplication()
                .createApplicationContainer(Collections.<String, Object>emptyMap());
        stage.setTitle(getApplication().getConfiguration().getAsString("application.title"));
        tabPane = new TabPane();
        stage.setScene(new Scene(tabPane));
        stage.sizeToScene();
        getApplication().getWindowManager().attach("mainWindow", stage);
    }
}