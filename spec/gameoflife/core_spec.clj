(ns gameoflife.core-spec
  (:require [speclj.core :refer :all]
            [gameoflife.core :refer :all]))

(def dead-world-3 (dead-world 3))

(def test-world-3 [[:dead :alive :dead]
                   [:dead :alive :dead]
                   [:dead :alive :alive]])

(describe "World functions"

  (it "should generate an dead world of size 10"
    (should= [[:dead :dead :dead :dead :dead]
              [:dead :dead :dead :dead :dead]
              [:dead :dead :dead :dead :dead]
              [:dead :dead :dead :dead :dead]
              [:dead :dead :dead :dead :dead]]
      (dead-world 5))))
   
(describe "Life and death"

  (it "should identify a cell as alive"
    (should (alive? :alive)))

  (it "should identify a cell as dead"
    (should (dead? :dead)))

  (it "should identify a coordinate as alive"
    (should (alive-cell-at-xy? [1 1] test-world-3)))

  (it "should identify a coordinate as dead"
    (should (dead-cell-at-xy? [0 0] test-world-3))))


(describe "Neighbours"
  (it "should the neighbours for in a world"
    (should= [[0 0] [1 0] [2 0] [0 1] [2 1] [0 2] [1 2] [2 2]]
      (neighbour-coords dead-world-3 [1 1])))
  
  (it "should not include coordinates with negative values"
    (should= [[1 0] [0 1] [1 1]]
      (neighbour-coords dead-world-3 [0 0])))

  (it "should return the actual values of neighbours"
    (should= [:dead :dead :dead]
      (neighbours dead-world-3 [[1 0] [0 1] [1 1]]))))

(describe "Alive and dead neighbours"

  #_(it "should identify the alive neighbours"
    (should= [[1 0] [1 2] [2 2]]
      (alive-neighbour-coords test-world-3 [1 1]))))
    



  
