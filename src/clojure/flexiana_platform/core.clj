(ns flexiana-platform.core
  "FIXME: docstring for this namespace"
  (:require
   [clj-http.client :as http]
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


(defn get-weather-by-city [city]
  (let [response (http/get (str "https://api.openweathermap.org/data/2.5/weather?q=" city "&appid=374375cade0b557f6ff8ef1771107df5"))]
    (:body response)))