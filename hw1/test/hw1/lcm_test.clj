(ns hw1.lcm-test
  (:require [clojure.test :refer :all]
            [hw1.lcm :refer :all]))

(deftest lcm-test
  (testing "one input"
    (is (= (lcm 1) 1)))
  (testing "two inputs"
    (is (= (lcm 1 1) 1))
    (is (= (lcm 1 2) 2))
    (is (= (lcm 2 1) 2))
    (is (= (lcm 6 9) 18))
    (is (= (lcm 9 6) 18)))
  (testing "multiple inputs"
    (is (= (lcm 1 2 3) 6))
    (is (= (lcm 3 5 6) 30))
    (is (= (lcm 3 5 6 10) 30))))
