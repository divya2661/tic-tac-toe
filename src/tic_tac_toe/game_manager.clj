(ns tic-tac-toe.game-manager
  (:require [tic-tac-toe.board :refer :all]))

(def win-conditions '((0 1 2) (3 4 5) (6 7 8) (0 3 6)
                       (1 4 7) (2 5 8) (0 4 8) (6 4 2)))

(defn- win-condition-met? [board win-condition]
  (let [p1 (board (first win-condition))
        p2 (board (second win-condition))
        p3 (board (last win-condition))]
    (and p1 p2 p3 (= p1 p2 p3) (not= p1 nil))))

(defn win? [board]
  (let [first (first (drop-while #(not= true (win-condition-met? board %)) win-conditions))]
    (if first true false)))

(defn get-valid-move [board]
  (let [valid-indexes (vec (get-nil-indexes board))]
    (valid-indexes (rand-int (count valid-indexes)))))