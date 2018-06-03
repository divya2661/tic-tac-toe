(ns tic-tac-toe.board-test
  (:require [clojure.test :refer :all])
  (:require [tic-tac-toe.board :refer :all]))

(deftest create-board-test
  (is (= [nil nil nil nil nil nil nil nil nil] (create-board))))

(deftest cell-empty?-test
  (is (= (cell-empty? [nil nil nil] 0) true))
  (is (= (cell-empty? [nil "X" nil] 1) false)))