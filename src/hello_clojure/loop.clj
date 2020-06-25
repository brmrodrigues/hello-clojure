(ns loop)

(defn indexed [coll]
  (map-indexed vector coll))

(indexed "abc")

(defn index-filter [pred coll]
  (when pred
    (for [[idx elt] (indexed coll)
          :when (pred elt)]
      idx)))

(index-filter #{\a \b} "abcdbbb")
(index-filter #{\a \b} "xyz")

(defn index-of-any [pred coll]
  (first (index-filter pred coll)))

(index-of-any #{\a \b} "fbcdbbb")
(index-of-any #{\b \y} "zzabyycdxx")
