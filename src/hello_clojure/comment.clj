(ns comment)

; (println "commented ; here")

(comment
  (defn ignore-me []
    ;; FIXME here because of lol
    (println "aaa ignore-me")))

; (ignore-me)

(defn ten-times [number]
  #_(println "Number:" number)
  (* 10 number))

(ten-times 2)
