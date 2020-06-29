(ns hello-clojure.lazy-sequences)

(def x (for [i (range 1 3)]
         (do (println i)
           i)))

(doall x)
(dorun x)
