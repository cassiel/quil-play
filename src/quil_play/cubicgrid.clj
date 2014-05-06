(ns quil-play.cubicgrid
  (:use [quil.core]))

(def BOXSIZE 40)
(def MARGIN (* BOXSIZE 2))
(def WIDTH 400)
(def HEIGHT 400)
(def DEPTH 400)

(defn setup []
  (no-stroke))

(defn draw []
  (background 255)

  (with-translation [(/ WIDTH 2) (/ HEIGHT 2) (- DEPTH)]
    (rotate-y (* (frame-count) 0.01))
    (rotate-x (* (frame-count) 0.01))
    (rotate-z (* (frame-count) 0))

    (dorun
     (for [i (range (- MARGIN (/ DEPTH 2))
                    (- (/ DEPTH 2) MARGIN)
                    BOXSIZE)
           j (range (- MARGIN HEIGHT)
                    (- HEIGHT MARGIN)
                    BOXSIZE)
           k (range (- MARGIN WIDTH)
                    (- WIDTH MARGIN)
                    BOXSIZE)]
       (let [ #_ (color (abs i) (abs j) (abs k) 10)
             c-idx (mod (+ i j k) 2)
             c (* c-idx 255)
             (color c c c 10)
             box-fill ()]
         (with-translation [k j i]
           (fill box-fill)
           (box BOXSIZE BOXSIZE BOXSIZE)))))))

(defsketch cubicgrid
  :title "Cubic Grid"
  :size [400 400]
  :renderer :p3d
  :setup setup
  :draw draw)
