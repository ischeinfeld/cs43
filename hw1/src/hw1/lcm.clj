(ns hw1.lcm)

(defn gcd-pair
  "Returns the greatest common divisor of two positive integers"
  [m n]
  (if (zero? n)
    m
    (recur n (mod m n))))

(defn lcm-pair
  "Returns the least common multiple of two positive integers."
  [m n]
  (/ (* m n)
     (gcd-pair m n)))

(defn scale-to-integers
  "Returns the product of the distinct denominators in numbers"
  [& numbers]
  (let [fractions (filter ratio? numbers)
        denoms (map denominator fractions)]
    (reduce * (set denoms))))

(defn lcm
  "Returns the least common multiple of multiple integers and fractions."
  [& numbers]
  (let [scale (scale-to-integers numbers)
        integers (map #(* % scale) numbers)]
    (/ (reduce lcm-pair integers) scale)))
