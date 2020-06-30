(ns java-seq
  (:require [clojure.java.io :refer [reader]])
  (:import [java.io File]))

(first (.getBytes "hello"))
(rest (.getBytes "hello"))
(cons (int \h) (.getBytes "ello"))

(first (System/getProperties))
(rest (System/getProperties))

(first "Hello")
(rest "Hello")
(cons \H "ello")

(reverse "Hello")
(apply str (reverse "Hello"))

(re-seq #"\w+" "the quick brown fox")
(sort (re-seq #"\w+" "the quick brown fox"))
(drop 2 (sort (re-seq #"\w+" "the quick brown fox")))
(map clojure.string/upper-case (re-seq #"\w+" "the quick brown fox"))

(.listFiles (File. "."))
(seq (.listFiles (File. ".")))
(map #(.getName %) (.listFiles (File. ".")))
(count (file-seq (File. ".")))

(defn minutes-to-millis [mins]
  (* mins 1000 60))

(defn recently-modified? [file]
  (> (.lastModified file)
     (- (System/currentTimeMillis) (minutes-to-millis 30))))

(filter recently-modified? (file-seq (File. ".")))

;leaves reader open
(take 2 (line-seq (reader "src/hello_clojure/core.clj")))

(with-open [rdr (reader "src/hello_clojure/core.clj")]
  (count (line-seq rdr)))

(with-open [rdr (reader "src/hello_clojure/core.clj")]
  (count (filter #(re-find #"\S" %) (line-seq rdr))))
