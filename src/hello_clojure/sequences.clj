(ns hello-clojure.sequences
  (:require [clojure.string :as str]))

(seq '(1 2 3))
(seq [1 2 3])

(seq? (rest [1 2 3]))
(seq? (cons 0 [1 2 3]))

(first {:a 1
        :b 2
        :c 3
        :d 4})

(rest {:a 1
       :b 2
       :c 3})

(cons [:a 1] {:b 2
              :c 3
              :d 4})

(first #{:a :b :c :d})
(rest #{:a :b :c :d})
(cons :a #{:b :c :d})

(sorted-set :a :b :c :d)
{:a 1 :b 2 :c 3 :d 4}
(sorted-map :a 1 :b 2 :c 3 :d 4)

(conj '(1 2 3) 0)
(into '(1 2 3) '(:a :b :c))
(conj [1 2 3] 4)
(into [1 2 3] [:a :b :c])

(range -2.5 2.5 0.25)

(repeat 5 [1 2 3])

(iterate inc 1)

(take 10 (iterate inc 1))

(def whole-numbers (iterate inc 1))

(take 20 (repeat 1))

(take 10 (cycle (range 3)))

(interleave [1 2 3] [4 5 6])
(interleave [:a :b :c :d :e] whole-numbers)

(apply str (interpose "-" ["cat" "dog" "ant"]))
(str/join \- ["cat" "dog" "ant"])

(list 1 :a "pog")
(vector :2 ::c "3")
(hash-set "a" "b" "c")
(hash-map :a 1 :b 2 :c "3")

(vec (range 10))

(take 6 (filter even? (range 30)))
(take-while #(< % 4) (range 10))
(drop-while #(< % 4) (range 10))
(split-at 3 (range 10))
(split-with #(< % 4) (range 10))

(some #{4} [1 2 3 4 5])
(not-every? even? whole-numbers)
(not-any? even? whole-numbers)

(sort-by :grade > [{:name "A"
                    :grade 39}
                   {:name "B"
                    :grade 10}
                   {:name "C"
                    :grade 100}])

;; COMPREHENSIONS
;; emulate map
(for [word ["a" "lol" "game"]]
  (str/upper-case word))

;; emulate filter
(take 10 (for [n whole-numbers :when (and (> n 50) (even? n))] n))

;; continues evaluation while expression holds true
(for [n whole-numbers :while (< n 12)] n)

;; multiple bind expressions
(for [file "ABCDEFGH"
      rank (range 1 9)]
  (format "%c%d" file rank))
