(ns hw1.compose-test
  (:require [clojure.test :refer :all]
            [hw1.compose :refer :all]))

(deftest compose-test
  (testing "no functions"
    (is (= ((compose) 1) ((comp) 1))))
  (testing "one function"
    (is (= ((compose inc) 1) ((comp inc) 1)))
    (is (= ((compose +) 1 1) ((comp +) 1 1))))
  (testing "two functions"
    (is (= ((compose inc inc) 1) ((comp inc inc) 1)))
    (is (= ((compose inc +) 1 1) ((comp inc +) 1 1))))
  (testing "three functions"
    (is (= ((compose inc inc inc) 1) ((comp inc inc inc) 1)))
    (is (= ((compose inc inc +) 1 1) ((comp inc inc +) 1 1))))
  (testing "variadic inner function"
    (is (= ((compose inc inc +) 1 1 1 1) ((comp inc inc +) 1 1 1 1)))))
