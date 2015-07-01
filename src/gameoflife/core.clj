(ns gameoflife.core)

(defn dead-world [n]
  (->> :dead
       repeat
       (take n)
       (into [])
       repeat
       (take n)
       (into [])))

(defn alive? [cell]
  (= cell :alive))

(defn alive-cell-at-xy? [xy world]
  (alive? (get-in world xy)))

(defn dead? [cell]
  (= cell :dead))

(defn dead-cell-at-xy? [xy world]
  (dead? (get-in world xy)))

(defn add-coords [xy delta]
  (map + xy delta))
         
(defn neighbour-coords [world xy]
  (let [deltas [[-1 -1] [0 -1] [1 -1] [-1 0]
                [1 0] [-1 1] [0 1] [1 1]]]
    (->> (map #(add-coords xy %) deltas)
         (filter #(not-any? neg? %)))))

(defn neighbours [world coords]
  (map #(get-in world %) coords))
