(ns tic-tac-toe.player-manager)

(def players {:human "X" :computer "O"})

(defn switch-player [current-player]
  (if (= current-player :human) :computer :human ))

(defn get-player-marker [player]
  (player players))

