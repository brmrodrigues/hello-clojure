(ns lazier)

; [:h :t :t :h :h :h] => two pairs

(defn count-heads-pairs [coll]
  (loop [cnt 0 coll coll]
    (if (empty? coll)
      cnt
      (recur (if (= :h (first coll) (second coll))
               (inc cnt)
               cnt)
        (rest coll)))))

(count-heads-pairs [:h :t :t :h :h :h])
(count-heads-pairs [:h :t :h :t :h])

(def my-h-t-coll [:h :t :t :h :h :h])

(defn by-pairs [coll]
  (let [take-pair (fn [c]
                   (when (next c) (take 2 c)))]
    (lazy-seq
     (when-let [pair (take-pair coll)]
       (cons pair (by-pairs (rest coll)))))))

(by-pairs my-h-t-coll)

(defn count-head-pairs [coll]
  (count (filter (fn [pair] (every? #(= :h %) pair))
           (by-pairs coll))))

(count-head-pairs my-h-t-coll)

; instead of doing by-pairs we could use partition function
(partition 2 [:h])
(partition 2 my-h-t-coll)

(def ^{:doc "Count items matching a filter"}
  count-if (comp count filter))

(count-if odd? [1 3 5 7 9 10])

(defn every-h? [pair]
  (every? #(= :h %) pair))
(count-if every-h? (partition 2 1 my-h-t-coll))

(defn count-runs [n pred coll]
  (count-if #(every? pred %) (partition n 1 coll)))

(count-runs 2 #(= % :h) my-h-t-coll)
(count-runs 3 #(= % :h) my-h-t-coll)
(count-runs 2 #(= % :t) my-h-t-coll)

(def ^{:doc "Count runs of length two that are both heads"}
  count-head-pairs (partial count-runs 2 #(= % :h)))
(count-head-pairs my-h-t-coll)
