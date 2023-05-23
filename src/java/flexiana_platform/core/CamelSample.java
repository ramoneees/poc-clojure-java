package flexiana_platform.core;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

import clojure.java.api.Clojure;
import clojure.lang.IFn;

public class CamelSample {

    private static ClojureCamelBean camelBean;

    public void simpleRoute() throws Exception {
        // create a CamelContext
        try (CamelContext camel = new DefaultCamelContext()) {

            // add routes which can be inlined as anonymous inner class
            // (to keep all code in a single java file for this basic example)
            camel.addRoutes(createBasicRoute());

            // start is not blocking
            camel.start();

            // so run for 10 seconds
            Thread.sleep(10_000);

            camel.stop();
        }
    }

    static RouteBuilder createBasicRoute() {
        return new RouteBuilder() {
            @Override
            public void configure() {
                from("timer:foo")
                        .bean(ClojureCamelBean.class, "testFoo")
                        .log("He ${body}");
            }
        };
    }

}
