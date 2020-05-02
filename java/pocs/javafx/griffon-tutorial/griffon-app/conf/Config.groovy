application {
    title = 'griffon-tutorial'
    startupGroups = ['griffonTutorial']
    autoShutdown = true
}
mvcGroups {
    // MVC Group for "griffonTutorial"
    'griffonTutorial' {
        model      = 'tutorial.GriffonTutorialModel'
        view       = 'tutorial.GriffonTutorialView'
        controller = 'tutorial.GriffonTutorialController'
    }
}