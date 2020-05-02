import griffon.util.AbstractMapResourceBundle;

import javax.annotation.Nonnull;
import java.util.Map;

import static java.util.Arrays.asList;
import static griffon.util.CollectionUtils.map;

public class Config extends AbstractMapResourceBundle {
    @Override
    protected void initialize(@Nonnull Map<String, Object> entries) {
        map(entries)
                .e("application", map()
                                .e("title", "demogriffonfx2")
                                .e("startupGroups", asList("demogriffonfx2"))
                                .e("autoShutdown", true)
                ).e("mvcGroups", map()
                        .e("demogriffonfx2", map()
                                        .e("view", "demogriffonfx.Demogriffonfx2View")
                        )
                        .e("tab1", map()
                                        .e("model", "demogriffonfx.SampleModel")
                                        .e("view", "demogriffonfx.Tab1View")
                                        .e("controller", "demogriffonfx.SampleController")
                        )
                        .e("tab2", map()
                                        .e("model", "demogriffonfx.SampleModel")
                                        .e("view", "demogriffonfx.Tab2View")
                                        .e("controller", "demogriffonfx.SampleController")
                        )
                        .e("tab3", map()
                                        .e("model", "demogriffonfx.SampleModel")
                                        .e("view", "demogriffonfx.Tab3View")
                                        .e("controller", "demogriffonfx.SampleController")
                        )
                        .e("tab4", map()
                                        .e("model", "demogriffonfx.SampleModel")
                                        .e("view", "demogriffonfx.Tab4View")
                                        .e("controller", "demogriffonfx.SampleController")
                    )
                );


    }
}