(ns tic-tac-toe.board-test
  (:require [clojure.test :refer :all])
  (:require [tic-tac-toe.board :refer :all]))

(deftest create-board-test
  (is (= [nil nil nil nil nil nil nil nil nil] (create-board))))

(deftest cell-empty?-test
  (is (= (cell-empty? [nil nil nil] 0) true))
  (is (= (cell-empty? [nil "X" nil] 1) false)))

(deftest valid-input?-test
  (let [board [nil "X" nil nil nil nil nil nil nil]]
    (is (= (valid-input? board 10) false))
    (is (= (valid-input? board 1) false))
    (is (= (valid-input? board 2) true))))

(deftest updated-board-test
  (let [board [nil "X" nil nil nil nil nil nil nil]]
    (is (= (updated-board board 2 "O") [nil "X" "O" nil nil nil nil nil nil]))
    (is (= (updated-board board 10 "O") [nil "X" nil nil nil nil nil nil nil]))))

(deftest get-nil-indexes-test
  (is (= (get-nil-indexes [nil nil nil "X" "X" "X" nil]) '(0  1 2 6)))
  (is (= (get-nil-indexes ["X" "X" "X"]) '())))
