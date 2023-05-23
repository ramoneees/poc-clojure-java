package flexiana_platform.core;

import clojure.java.api.Clojure;
import clojure.lang.IFn;
import org.apache.camel.Handler;

public class ClojureCamelBean {

    private static IFn clojureRequire;
    private static IFn flexianaPlatformFn;

    private static IFn getWeatherByCityFn;

    public ClojureCamelBean() {
        clojureRequire = Clojure.var("clojure.core", "require");
        clojureRequire.invoke(Clojure.read("flexiana-platform.core"));
        flexianaPlatformFn = Clojure.var("flexiana-platform.core", "test-foo");
        getWeatherByCityFn = Clojure.var("flexiana-platform.core", "get-weather-by-city");
    }

    @Handler
    public Object testFoo() {
        return flexianaPlatformFn.invoke();
    }

    @Handler
    public Object getWeatherByCity(String city) {
        return getWeatherByCityFn.invoke(city);
    }

}
