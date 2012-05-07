(ns quil-play.translate
  (:use [quil.core]))

(def SIZE 40.0)

(defn setup []
  (set-state! :x (atom 0))
  (size 200 200)
  (no-stroke)
  (frame-rate 30))

(defn draw []
  (background 102)
  (let [x (+ @(state :x) 0.8)
        x' (if (> x (+ (width) SIZE))
             (- SIZE)
             x)]
    (reset! (state :x) x')

    (with-translation [x' (- (/ (height) 2) (/ SIZE 2))]
      (fill 255)
      (rect (- (/ SIZE 2)) (- (/ SIZE 2)) SIZE SIZE)

      (with-translation [x' SIZE]
        (fill 0)
        (rect (- (/ SIZE 2)) (- (/ SIZE 2)) SIZE SIZE)))))

(defsketch translate_
  :title "translate"
  :size [200 200]
  :setup setup
  :draw draw)
