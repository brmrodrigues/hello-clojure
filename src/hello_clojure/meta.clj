(ns meta
  (:require [clojure.string :as str]))

(meta #'str)

(defn ^{:tag String} shout [^{:tag String} s]
  (str/upper-case s))

(shout "huehue-brbr")
(meta #'shout)

(defn ^String shout-2 [^String s]
  (str/upper-case s))

(shout-2 "hahaha")
(meta #'shout-2)
