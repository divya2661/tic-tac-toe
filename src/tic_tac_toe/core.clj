(ns tic-tac-toe.core
  (:require [tic-tac-toe.board :refer :all]
            [tic-tac-toe.player-manager :refer :all]
            [tic-tac-toe.game-manager :refer :all]
            [clojure.core]))

(defn- get-cell [s]
  (try
    (- (Integer/parseInt s) 1)
    (catch NumberFormatException nfe
      (println "Please type an integer") -1)))

(defn- get-input [board player]
  (if (= player :computer)
    (get-valid-move board)
    (get-cell (read-line))))

(defn game-start [board player]
  (println "\n==================================\n")
  (print-board board)
  (let [input (get-input board player)]
    (if (valid-input? board input)

      (let [updated-board (updated-board board input (get-player-marker player))]
        (if (win? updated-board)
          ((println (str "Congrats: player " (get-player-marker player) " you win"))
            (System/exit 0))
          (game-start updated-board (switch-player player))))

      ((println "Invalid input")
        (game-start board player)))))

(defn game-setup []
  (let [board (create-board)]
    (println "This is the board,  user is X and robot is O. ")
    (game-start board :human)))


(defn -main [& args]
  (game-setup)
  (println "Hello, World!"))
