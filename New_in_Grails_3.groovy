/**
* New Testing Framework: Easier to debug, cleaner with a focus on Traits.
*
* GORM 6.1
*   - Removes more of the metapromgramming in GORM to focus even more on Traits.
*   - Some AST annotations have been moved from Grails to GORM.
*   - Some session and transaction based closures such as withTransaction have
*     been moved to SessionService and TransactionService in GORM.
*   - Code completion for Mapping block should be greatly imporved.
*   - Restoration of JPA Annotations in GORM for Hibernate.
*   - HQL and SQL queries will now have automatic escaping for queries passed as GStrings to help prevent
*     SQL injection attacks.
* Example of Data service below:
*/
package demo
import grails.gorm.services.service

@Service(Person)
interface PersonService{

    Person find(String firstName)

    Person savePerson(Sting firstName, String lastName, LocalDate dob)

    @Query("select $p.firstName from ${Person p} where $p.lastName = $lastName")
    List<String> findFirstNames(String lastName)
}

/**
* New EventBus:
* - Not tied to Reactor 2.x.
* - GORM integration.
* - @Publisher and @Subscriber annotations for async Event participation.
* - @Listener annotation for sync events such as GORM events ex: @Listener(Book) if Book is a Domain.
* - Fully transaction aware; events are only published if the transaction completes successfully.
*
* New Testing Framework:
* - Simplified testing based on traits. See http://testing.grails.org
* 
* JSON Views 1.2:
* - Introduces JSON-API spec suppport. See http://jsonapi.org and http://views.grails.org/latest#json_api_specification
*
* Other Notables:
* - AST Transform based Cache plugin
* - Gradle 4.x support
* - Slimmer WAR and JAR for core plugins.
*
* GORM 7 will REQUIRE Hibernate 5.2+ and Java 8+
*
* Project Particle:
* - Smaller Footprint Runtime
* - Native Micro Services Support
* - Reactive and Blocking APIs
* - HTTP Server and HTTP Client
* - GORM/RxGORM Integration
*/

