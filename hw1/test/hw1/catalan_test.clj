(ns hw1.catalan-test
  (:require [clojure.test :refer :all]
            [hw1.catalan :refer :all]))

(deftest catalan-test
  (testing "first 10"
    (is (= (take 10 (catalan))
           '(1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862)))))
