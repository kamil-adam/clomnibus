(ns clomnibus.core
  (:gen-class))

(require '[clojure.data.csv :as csv]
         '[clojure.java.io :as io])

(defn data-io []
  (with-open [reader (io/reader "in-file.csv")]
    (doall
      (csv/read-csv reader)))

  (with-open [writer (io/writer "out-file.csv")]
    (csv/write-csv writer
                   [["abc" "def"]
                    ["ghi" "jkl"]]))
  )


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (data-io)
  (println "Hello, World!"))

(require '[clojure.data.csv :as csv]
         '[clojure.java.io :as io])

