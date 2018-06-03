(ns tic-tac-toe.player-manager-test
  (:require [clojure.test :refer :all])
  (:require [tic-tac-toe.player-manager :refer :all]))

(deftest switch-player-test
  (is (= (switch-player :human) :computer))
  (is (= (switch-player :computer) :human)))

(deftest get-player-marker-test
  (is (= (get-player-marker :human) "X"))
  (is (= (get-player-marker :computer) "O")))
