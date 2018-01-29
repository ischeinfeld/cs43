(ns hw1.compose)

(defn compose
  "An implementation of the built in function comp"
  ([]
    identity)
  ([f]
    f)
  ([f g]
    (fn [& args] (f (apply g args))) )
  ([f g & gs]
    (let [fs (conj gs g f) ]
      (reduce compose fs))))

(comment
  ((compose) 1)
  ((compose inc) 1)
  ((compose +) 1 1)
  ((compose inc inc) 1)
  ((compose inc +) 1 1)
  ((compose inc inc +) 1 1)
  ((compose inc inc inc +) 1 1 1))
