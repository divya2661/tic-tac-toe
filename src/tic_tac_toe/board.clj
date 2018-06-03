(ns tic-tac-toe.board)

(defn create-board []
  (vec (repeat 9 nil)))

(defn- suffix [board_num]
  (cond (> board_num 7) ""
        (= 2 (mod board_num 3)) "\n---------\n"
        :else " | "))

(defn- get-item-value [idx itm]
  (cond
    (nil? itm) (+ idx 1)
    :else itm))

(defn cell-empty? [board cell-number]
  (if (nil? (nth board cell-number)) true false))

(defn valid-input? [board cell-number]
  (if (and (< cell-number 9)
           (> cell-number -1)
           (cell-empty? board cell-number)) true false))

(defn updated-board [board input marker]
  (if (valid-input? board input)
    (assoc board input marker)
    board))

(defn get-nil-indexes [board]
  (filter #(not= nil %) (map-indexed (fn [idx itm]
                             (if (nil? itm) idx nil)) board)))

(defn print-board [board]
  (println (apply str
                  (map-indexed (fn [idx itm]
                                 (str (get-item-value idx itm) (suffix idx))) board))))
