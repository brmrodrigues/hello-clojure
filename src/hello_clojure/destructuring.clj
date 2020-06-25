(ns destructuring
  (:require [clojure.string :as str]))

(defn greet-2
  "A second greet version ;)"
  [{primeiro-nome :first-name}]
  (prn "FIRST NAME:" primeiro-nome))

(defn greet-3 [{:keys [first-name]}]
  (prn "FIRST NAME:" first-name))

(greet-2 {:first-name "Bruno"
          :last-name "Rodrigues"})

(greet-3 {:first-name "Bruno"
          :last-name "Rodrigues"})

(let [ [x _ z :as numbers] [1 2 3 4 5 6]]
  (prn [x z])
  numbers)

(defn ellipsize [words]
  (let [[w1 w2 w3] (str/split words #"\s+")]
    (str/join " " [w1 w2 w3 "..."])))

(ellipsize "My Name is Bruno Rodrigues")
