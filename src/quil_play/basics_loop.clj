(ns quil-play.basics-loop
  (:use [quil.core]))

(defn setup []
  (set-state! :y (atom 100))
  (stroke 255))

(defn draw []
  (let [y (swap! (state :y)
                 #(mod (dec %) (height)))]
    (background 0)
    (line 0 y (width) y)))

(defsketch basics-loop
  :title "basics-loop"
  :size [200 200]
  :setup setup
  :draw draw)
