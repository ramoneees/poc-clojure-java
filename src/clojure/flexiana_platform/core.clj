(ns flexiana-platform.core
  "FIXME: docstring for this namespace"
  (:require
   [clojure.spec.alpha :as s]
   [clojure.spec.gen.alpha :as gen]
   [clojure.spec.test.alpha :as stest]))

(s/fdef foo
  :args (s/cat :x any?)
  :ret nil?)
(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World! (from Clojure)"))


(defn test-foo []
  (+ 2 2))
