/**
* Can use the 'jndiName' attribute in application.yml to specify connection URL, username and password in a local
* file rather than have this information living in the application source code.

* There are also configuration options available through jndi.

* Multi-tenancy support in GORM has the ability to separate tenants by database, schema or a discriminator column.

* Domain classes that need to participate in multi-tenancy need to implement the MultiTenant<V> class.

* start.grails.org is a resource that can be used to generate a new Grails application with a GUI to configure it.

* New resource: guides.grails.org

* Phone System update: Look at separating the RESTful domain controllers from the 'action' controllers to remove the
* gson view bulk and complexity

* Overriding 'listAllResources' in a RESTful Controller can add some filtering capabilities to enable URI based querying
* along the lines of '/genre/PROGRESSIVE_ROCK/albums' handled by the same action as the general '/albums' which lists all
* created albums.

* For listing actions (of domains) it is important to have a limiting line like in the code below to keep large requests/DDOS
* attacks via the 'max' parameter
*/

def index(){
    params.max Math.min(max ?: 10, 100)
    DomainClass.list(params)
}

/**
* Look into adding the spring-security-rest plugin to VoicemailHelper to authenticate
* requests for voicemails and recordings.
*/