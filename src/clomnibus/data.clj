(ns clomnibus.data
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
                    ["ghi" "jkl"]])))

(defn csv-data->maps [csv-data]
  (map zipmap
       (->> (first csv-data) ;; First row is the header
            (map keyword) ;; Drop if you want string keys instead
            repeat)
       (rest csv-data)))

(defn csv-file->maps [file]
  (csv-data->maps (csv/read-csv (io/reader file))))

;(->> (read-csv reader)
;     csv-data->maps
;     (map (fn [csv-record]
;            (update csv-record :bar #(Long/parseLong %)))))