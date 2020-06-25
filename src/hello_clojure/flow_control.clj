(ns flow-control)

; In Clojure, side effects are explicit and unusual.
; do is one way to say “side effects to follow.”
; Since do ignores the return values of all its forms except the last,
; those forms must have side effects to be of any use at all.

(loop [result [] x 10]
  (if (zero? x)
    result
    (recur (conj result x) (dec x))))

(defn countdown-recur [result x]
  (if (zero? x)
    result
    (recur (conj result x) (dec x))))

(countdown-recur [] 5)

(defn countdown-lazy [x]
  (into [] (take x (iterate dec x))))

(countdown-lazy 5)

(defn countdown-lazy-drop-last [x]
  (into [] (drop-last (reverse (range (inc x))))))

(countdown-lazy-drop-last 5)

(defn countdown-lazy-reverse [x]
  (vec (reverse (rest (range (inc x))))))

(countdown-lazy-reverse 5)
