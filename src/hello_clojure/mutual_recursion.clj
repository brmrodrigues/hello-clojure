(ns mutual-recursion)

(declare my-odd? my-even?)

(defn my-odd? [n]
  (if (= n 0)
    false
    (my-even? (dec n))))

(defn my-even? [n]
  (if (= n 0)
    true
    (my-odd? (dec n))))

(map my-even? (range 10))
(map my-odd? (range 10))
;(my-even? 1000000) => stack-overflow here
; we can't use recur directly here, cause it only works for self-recursion D:

; Converting to Self-Recursion
(defn parity [n]
  (loop [n n par 0]
    (if (= n 0)
      par
      (recur (dec n) (- 1 par)))))

(map parity (range 10))

(defn my-even-parity? [n] (= 0 (parity n)))
(defn my-odd-parity? [n] (= 1 (parity n)))
(map my-even-parity? (range 10))
(map my-odd-parity? (range 10))

; Trampolining
(trampoline list)
(trampoline + 1 2)

(declare my-even-trampoline? my-odd-trampoline?)

(defn my-odd-trampoline? [n]
  (if (= n 0)
    false
    #(my-even-trampoline? (dec n))))

(defn my-even-trampoline? [n]
  (if (= n 0)
    true
    #(my-odd-trampoline? (dec n))))

(trampoline my-even-trampoline? 1000000) ; SUCCESS :D

; Memoization

(declare m f)

(defn m [n]
  (if (zero? n)
    0
    (- n (f (m (dec n))))))

(defn f [n]
  (if (zero? n)
    1
    (- n (m (f (dec n))))))

(time (m 500))

(def m (memoize m))
(def f (memoize f))

(time (m 500))

; (m 1000) => stack-overflow here

(def m-seq (map m (iterate inc 0)))
(def f-seq (map f (iterate inc 0)))

(time (nth m-seq 1000)); SUCCESS :D
