@Grab('io.ratpack:ratpack-groovy:1.4.6')

import static ratpack.groovy.Groovy.ratpack

ratpack {
    handlers{
        get{
            render "Hello, world!"
        }
    }
}