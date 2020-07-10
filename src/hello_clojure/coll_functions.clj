(ns coll-functions
  (:require [clojure.set :as clj-set]))

(def my-list '(1 2 3))
(def my-vector [1 2 3])

(peek my-list)
(pop my-list)

(rest ())
; (pop ())

(peek my-vector)
(pop my-vector)

([:a :b :c] 1)
; ([:a :b :c] 3)

(assoc [0 1 2 3 4] 2 :new-value)
(subvec [1 2 3 4 5] 3)
(subvec [1 2 3 4 5] 1 3)

(keys {:a 1 :b 2 :c 3})
(vals {:a 1 :b 2 :c 3})

(get {:a 1 :b 2 "c" 3} :b)
({:a 1 :b 2 "c" 3} :b)
(:b {:a 1 :b 2 "c" 3})
; ("c" {:a 1 :b 2 "c" 3})
({:a 1 :b 2 "c" 3} "c")

(def my-map {:a 1 :b 2 "c" 3})
(select-keys my-map [:a "c"])

(merge-with str
            {:name "Bruno"
             :last-name "Rodrigues"}
            {:name "Ramos"
             :age 28})

; "SQL" operations

(def animals #{"rat" "dog" "cat" "alligator"})
(def colors #{"blue" "orange" "purple"})
(def new-colors #{"brown" "purple" "red"})

(clj-set/union animals colors)
(clj-set/intersection new-colors colors)
(clj-set/select #(< 3 (count %)) animals)

(def animal-set #{{:name "rat" :color "brown"}
                  {:name "alligator" :color "green"}})

(def new-animal-set #{{:nick "rat" :age 2}
                      {:nick "alligator" :age 4}
                      {:nick "cat" :age 12}})

(clj-set/rename animal-set {:name :nick-name})
(clj-set/select #(= (:name %) "rat") animal-set)
(clj-set/project animal-set [:color])

(clj-set/project
 (clj-set/join animal-set new-animal-set {:name :nick})
 [:nick :age :color])
