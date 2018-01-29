(ns hw1.poker
  (:require [clojure.math.combinatorics :as combo]))

(defn suit
  [card]
  (get card 0))

(defn rank
  [card]
  (get card 1))

(defn num-rank-sets
  [n hand]
  (let [rank-sets (combo/combinations (map rank hand) n)
        equal-sets (filter #(apply = %) rank-sets) ]
    (count equal-sets)))

(defn pair?
  [hand]
  (= (num-rank-sets 2 hand) 1))

(defn two-pair?
  [hand]
  (= (num-rank-sets 2 hand) 2))

(defn three-of-a-kind?
  [hand]
  (= (num-rank-sets 3 hand) 1))

(defn straight?
  [hand]
  (let [card-sequence [\A \1 \2 \3 \4 \5 \6 \7 \8 \9 \T \J \Q \K \A]
        straight-sets (map set (partition 5 1 card-sequence))
        rank-set (set (map rank hand))]
    (boolean (some #(= rank-set %) straight-sets))))

(defn flush?
  [hand]
  (apply = (map suit hand)))

(defn full-house?
  [hand]
  (let [rank-frequencies (sort (vals (frequencies (map rank hand))))]
    (= '(2 3) rank-frequencies)))

(defn four-of-a-kind?
  [hand]
  (= (num-rank-sets 4 hand) 1))

(defn straight-flush?
  [hand]
  (and (flush? hand)
       (straight? hand)))

(defn best-poker-hand
  [hand]
  (cond
    (straight-flush? hand) :straight-flush
    (four-of-a-kind? hand) :four-of-a-kind
    (full-house? hand) :full-house
    (flush? hand) :flush
    (straight? hand) :straight
    (three-of-a-kind? hand) :three-of-a-kind
    (two-pair? hand) :two-pair
    (pair? hand) :pair
    :else :high-card)) 

(comment
  (best-poker-hand ["H2" "H3" "H4" "H5" "H6"])
  (straight-flush? ["H2" "H3" "H4" "H5" "H6"])
  (straight-flush? ["H2" "H3" "H4" "H5" "D6"])
  (four-of-a-kind? ["H2" "D2" "H2" "S3" "H3"])
  (four-of-a-kind? ["H2" "D2" "H2" "S2" "H6"])
  (full-house? ["H2" "D2" "H2" "S3" "H3"])
  (full-house? ["H2" "D2" "H2" "S2" "H6"])
  (flush? ["H2" "H2" "H2" "H2" "H6"])
  (flush? ["H2" "D2" "H2" "S3" "H3"])
  (straight? ["H2" "D3" "H4" "S5" "H6"])
  (straight? ["H2" "D2" "H2" "S4" "H6"])
  (three-of-a-kind? ["H2" "D2" "H2" "S4" "H6"])
  (three-of-a-kind? ["H2" "D2" "H3" "S4" "H6"])
  (two-pair? ["H2" "D2" "H4" "S4" "H6"])
  (two-pair? ["H2" "D3" "H4" "S5" "H6"])
  (pair? ["H2" "D3" "H4" "S5" "H6"])
  (pair? ["HA" "DA" "HQ" "SJ" "HT"])
  (rank "HA")
  (suit "HA"))
