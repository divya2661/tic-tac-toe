(ns tic-tac-toe.game-manager-test
  (:require [clojure.test :refer :all])
  (:require [tic-tac-toe.game-manager :refer :all]))

(deftest win?-test
  (is (= (win? [nil nil nil nil nil nil nil nil nil]) false))
  (is (= (win? ["X" "X" "X" nil nil nil nil nil nil]) true))
  (is (= (win? ["X" nil "X" nil nil nil nil nil nil]) false)))
