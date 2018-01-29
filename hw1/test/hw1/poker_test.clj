(ns hw1.poker-test
  (:require [clojure.test :refer :all]
            [hw1.poker :refer :all]))

(deftest lcm-test
  (testing "all hands"
    (is (= (best-poker-hand ["H2" "H3" "H4" "H5" "H6"]) :straight-flush)))
    (is (= (best-poker-hand ["H2" "D2" "S2" "C2" "H6"]) :four-of-a-kind)) 
    (is (= (best-poker-hand ["H2" "D2" "S2" "H3" "D3"]) :full-house)) 
    (is (= (best-poker-hand ["H2" "H3" "H4" "H5" "H7"]) :flush)) 
    (is (= (best-poker-hand ["H2" "H3" "S4" "D5" "H6"]) :straight)) 
    (is (= (best-poker-hand ["H2" "D2" "S2" "H5" "H6"]) :three-of-a-kind)) 
    (is (= (best-poker-hand ["H2" "D2" "H3" "H3" "H6"]) :two-pair)) 
    (is (= (best-poker-hand ["H2" "D2" "D4" "S5" "H6"]) :pair)) 
    (is (= (best-poker-hand ["HA" "D3" "S4" "S5" "H6"]) :high-card)))
