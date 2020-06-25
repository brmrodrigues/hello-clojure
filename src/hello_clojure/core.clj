(ns hello-clojure.core
  (:require [clojure.repl :as repl]
            [clojure.java.javadoc :refer [javadoc]]))

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(def foo "Eu")

#'foo

(comment
 (repl/find-doc "ns-")
 (javadoc java.util.Random))
