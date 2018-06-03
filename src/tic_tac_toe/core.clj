(ns tic-tac-toe.core
  (:require [tic-tac-toe.board :refer :all]
            [tic-tac-toe.player-manager :refer :all]
            [tic-tac-toe.game-manager :refer :all]
            [clojure.core]))

(defn get-cell [s]
  (- (Integer/parseInt s) 1))

(defn game-start [board player]
  (print-board board)
  (let [input (get-cell (read-line))]
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
