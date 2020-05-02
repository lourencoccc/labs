application {
    title = 'demogriffonfx'
    startupGroups = ['demogriffonfx']
    autoShutdown = true
}
mvcGroups {
    // MVC Group for "demogriffonfx"
    'demogriffonfx' {
        model      = 'demogriffonfx.DemogriffonfxModel'
        view       = 'demogriffonfx.DemogriffonfxView'
        controller = 'demogriffonfx.DemogriffonfxController'
    }
}