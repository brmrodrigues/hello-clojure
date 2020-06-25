(ns java-interop)

(new java.util.Random)
(java.util.Random.)

(def random (java.util.Random.))
(. random nextInt)
(. random nextInt 50)

(def p (java.awt.Point. 10 20))
(. p x)
(. p y)

(. System lineSeparator)
(System/lineSeparator)
(. Math PI)
