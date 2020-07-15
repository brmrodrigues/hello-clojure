(ns fp-lazy)

(defn stack-consumming-fibo [n]
  (cond
    (= n 0) 0
    (= n 1) 1
    :else (+ (stack-consumming-fibo (- n 1))
             (stack-consumming-fibo (- n 2)))))

(stack-consumming-fibo 9)
(stack-consumming-fibo 1000000)

(defn tail-fibo [n]
  (letfn [(fib
           [current next n]
           (if (zero? n)
             current
             (recur next (+ current next) (dec n))))]
    (fib 0N 1N n)))

(tail-fibo 100)
(tail-fibo 1000000)

(defn lazy-seq-fibo
  ([]
   (concat [0 1] (lazy-seq-fibo 0N 1N)))
  ([a b]
   (let [n (+ a b)]
     (lazy-seq
      (cons n (lazy-seq-fibo b n))))))

(take 10 (lazy-seq-fibo))
(rem (nth (lazy-seq-fibo) 1000000) 1000)

(take 9 (iterate (fn [[a b]] [b (+ a b)]) [0 1]))

(defn fibo[]
  (map first (iterate (fn [[a b]] [b (+ a b)]) [0N 1N])))

(take 9 (fibo))

(def lots-of-fibs (take 1000000000 (fibo)))

(nth lots-of-fibs 100)

; holds the head: avoid using this approach
(def head-fibo (lazy-cat [0N 1N] (map + head-fibo (rest head-fibo))))
(take 10 head-fibo)
(nth head-fibo 1000000)
