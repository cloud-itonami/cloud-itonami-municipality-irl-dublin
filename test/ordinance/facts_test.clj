(ns ordinance.facts-test
  (:require [kotoba.lang.text :as str]
            [clojure.test :refer [deftest is]]
            [ordinance.facts :as facts]))

(deftest dublin-has-spec-basis
  (let [sb (facts/spec-basis "dublin")]
    (is (= 2 (count sb)))
    (is (every? #(str/starts-with? (:ordinance/url %) "https://") sb))
    (is (every? :ordinance/number sb))))

(deftest unknown-municipality-has-no-spec-basis
  (is (nil? (facts/spec-basis "cork")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["dublin" "cork"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["cork"] (:missing-municipalities c)))))

(deftest by-topic-filters
  (is (= 2 (count (facts/by-topic "dublin" :governance))))
  (is (empty? (facts/by-topic "dublin" :labor)))
  (is (empty? (facts/by-topic "cork" :governance))))
