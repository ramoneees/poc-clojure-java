package flexiana_platform.core;

import clojure.java.api.Clojure;
import clojure.lang.IFn;
class FlexianaPlatform {
    private static volatile FlexianaPlatform instance = null;
    private static Object mutex = new Object();
    private static IFn clojureRequire;
    private static IFn flexianaPlatformFn;
    private static CamelSample camelSample;

    private FlexianaPlatform() {
        clojureRequire = Clojure.var("clojure.core", "require");
        clojureRequire.invoke(Clojure.read("flexiana-platform.core"));
        flexianaPlatformFn = Clojure.var("flexiana-platform.core", "test-foo");
    }

    private static void callFoo(String s) {
        flexianaPlatformFn.invoke();
    }

    public static void run() {
        System.out.println("Hello, World! (from Java)");
        callFoo("Java calling!");
    }

    public static FlexianaPlatform getInstance() {
        FlexianaPlatform result = instance;
        if (result == null) {
            synchronized (mutex) {
                result = instance;
                if (result == null)
                    instance = result = new FlexianaPlatform();
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        FlexianaPlatform me = getInstance();
        camelSample = new CamelSample();
        try {
            camelSample.simpleRoute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
