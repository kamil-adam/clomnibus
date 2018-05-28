(ns clomnibus.core
  (:gen-class)
  (require [clomnibus.data :refer :all]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (data-io)
  (println  (csv-file->maps "resources/sosna.csv"))
  (println "Hello, World!"))

