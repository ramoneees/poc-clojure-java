package flexiana_platform.core;

import clojure.java.api.Clojure;
import clojure.lang.IFn;
import org.apache.camel.Handler;

public class ClojureCamelBean {

    private static IFn clojureRequire;
    private static IFn flexianaPlatformFn;

    public ClojureCamelBean (){
        clojureRequire = Clojure.var("clojure.core", "require");
        clojureRequire.invoke(Clojure.read("flexiana-platform.core"));
        flexianaPlatformFn = Clojure.var("flexiana-platform.core", "test-foo");
    }

    @Handler
    public Object testFoo (){
        return flexianaPlatformFn.invoke();
    }

}
