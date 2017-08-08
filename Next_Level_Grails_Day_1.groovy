//Groovy Metaprogramming:
    /**
    * Expando class implements setProperty, getProperty and methodMissing to enable
    * 'easy access' to the Groovy Metaprogramming capabilities on individual instances
    * of that class.
    *
    * The Groovy 'spread' operator (*) allows for passing a dynamic number of
    * arguments to be passed to a method.
    * EX:
    */
        def testMethod(arguments){
            if(some logical condition){
                // Equivalent to underlyingMethod(arguments[0], arguments[1])
                //except it dynamically includes all objects in arguments
                underlyingMethod(*arguments)
            }
            // pass a Collection of a single property of each argument
            // instead i.e. name
            else {
                otherMethod(arguments*.name)
            }
        }

    /**
    * Using propertyMissing() rather than get/setProperty() will enable the existence
    * of 'real' properties on an object alongside the dynamic properties.
    * 
    * Closures have a .delegate property that allow for method interception
    * similar to the methodMissing method described above.
    * EX:
    */
    def main(){
        def example = {
            append('This is ')
            append('a test.')
        }

        // Without this line, the above closure will throw a MissingMethodException when exectued
        example.delegate = new StringBuffer()

        example()
    }

    //OUTPUT: This is a test.

    /**
    * Simliarly, the .with method allows for an implied context of 'this.' to be applied to a block of code,
    * simplifying its syntax and making it more readable
    * EX:
    */

    def main(){
        def now = new Calendar()

        now.clear()
        now.year = 2017l
        now.day = 24
        now.month = 7
    }

    // CAN BECOME

    def main(){
        def now = new Calendar()

        now.with {
            year = 2017l
            day = 24
            month = 7
        }
    }

    /**
    * Methods can be added to Classes using the Class.metaClass prefix OR by having a class that has static overloads
    * EX:
    */

    // Class name does not matter
    package example

    class StringExtension {
        // Method must be static
        // First argument of this method defines which base class this method is added to
        // Method name is static or 'hard-coded'
        static String getPigLatin(String s){
            s[1..-1] + s[0] + 'ay'
        }
    }

    /**
    * Groovy knows where to find these base class extensions using the following descriptors
    * Descriptor files are based at src/main/resources and continues in the manner of the comment below
    */
    
    //# .../META-INF/services/org.codehaus.groovy.runtime.ExtensionModule
    moduleName=string-magic // Arbitrary value
    moduleVersion=1.0
    extensionClasses=example.StringExtension // comma separated list of classes

    /**
    * When using 'direct domain passing' use code such as below to take advantage of the generated psuedo-code including
    * its validation results
    */

    def create(Person p){
        if(!p.hasErrors()){
            // No errors, continue with Domain object creation
        } else {
            // Error handling for object creation
        }
    }

    /**
    * The type of a hasMany can be defined as below
    */

    class Artist {
        SortedSet albums

        static hasMany = [albums: Album]
    }

    /**
     * Dynamic finders are expensive in their very nature, especially as the number of criteria grows. Should probably
     * consider converting these to .where or .withCriteria statements.
     * HOWEVER, you cannot compare two properties on an object using .where
     * ACTUALLY the gorm documentation shows that you can so, I'll need to test this.
     * (http://gorm.grails.org/latest/hibernate/manual/index.html#whereQueries)
     *
     * For Transaction management that is proxiless (and therefore possibly more intuitive) make sure that the class
     * is using the org.grails.Transactional annotation, NOT the Spring annotation or 'static transactional = true'. Also,
     * the DEFAULT is equivalent to the 'static transactional = true' line so in order to 'turn this off' you would need
     * to include 'static transactional = false'.
     *
     * Worth researching what the isolation level of the jdbc-postgresql driver is by default to better understand consistency
     * models for the Phone System.
     * 
     */