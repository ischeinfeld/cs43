(ns hw1.catalan)

(defn catalan
  "Returns a lazy sequence of the catalan numbers"
  ([]
    (catalan 0 1))
  ([n prev]
    (lazy-seq (cons prev (catalan (inc n) (* (/ (+ (* 4 n) 2)
                                                (+ n 2))
                                             prev))))))

(take 50 (catalan))
