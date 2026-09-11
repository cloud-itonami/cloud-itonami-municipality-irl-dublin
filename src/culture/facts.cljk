(ns culture.facts
  "Regional-culture catalog for Dublin (Dublin City Council) -- local
  dishes, protected products, beverages, festivals and heritage sites,
  piggybacked onto this municipality compliance repo per ADR-2607171400
  (cloud-itonami-municipality-culture-catalog, in com-junkawasaki/root),
  sibling namespace to `ordinance.facts` (ADR-2607141700).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "municipality-slug -> vector of culture entries."
  {"dublin"
   [{:culture/id "dublin.dish.coddle"
     :culture/name "Coddle"
     :culture/name-local "Dublin coddle"
     :culture/municipality "dublin"
     :culture/country "IRL"
     :culture/kind :dish
     :culture/summary "Irish dish particularly associated with Dublin, the capital of Ireland."
     :culture/url "https://en.wikipedia.org/wiki/Coddle"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "dublin.dish.spice-bag"
     :culture/name "Spice bag"
     :culture/municipality "dublin"
     :culture/country "IRL"
     :culture/kind :dish
     :culture/summary "Fast-food dish popular in most of Ireland and inspired by Chinese cuisine, created around 2006 at the Sunflower Chinese takeaway in Templeogue, Dublin."
     :culture/url "https://en.wikipedia.org/wiki/Spice_bag"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "dublin.dish.irish-stew"
     :culture/name "Irish stew"
     :culture/municipality "dublin"
     :culture/country "IRL"
     :culture/kind :dish
     :culture/summary "Stew traditionally made with lamb or mutton, potatoes, onions and parsley, considered a national dish of Ireland."
     :culture/url "https://en.wikipedia.org/wiki/Irish_stew"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "dublin.dish.colcannon"
     :culture/name "Colcannon"
     :culture/municipality "dublin"
     :culture/country "IRL"
     :culture/kind :dish
     :culture/summary "Traditional Irish dish of mashed potatoes with cabbage, particularly popular on Saint Patrick's Day and the feast day of St. Brigid."
     :culture/url "https://en.wikipedia.org/wiki/Colcannon"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "dublin.product.dublin-bay-prawn"
     :culture/name "Dublin Bay prawn"
     :culture/municipality "dublin"
     :culture/country "IRL"
     :culture/kind :product
     :culture/summary "Nephrops norvegicus, known variously as the Norway lobster, Dublin Bay prawn, langoustine or scampi."
     :culture/url "https://en.wikipedia.org/wiki/Nephrops_norvegicus"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "dublin.beverage.guinness"
     :culture/name "Guinness"
     :culture/municipality "dublin"
     :culture/country "IRL"
     :culture/kind :beverage
     :culture/summary "Stout that originated in the brewery of Arthur Guinness at St. James's Gate, Dublin, where he started brewing ales in 1759."
     :culture/url "https://en.wikipedia.org/wiki/Guinness"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "dublin.beverage.jameson"
     :culture/name "Jameson Irish Whiskey"
     :culture/municipality "dublin"
     :culture/country "IRL"
     :culture/kind :beverage
     :culture/summary "Irish whiskey whose founder John Jameson established his distillery at Bow Street in Dublin in 1780, one of the six main Dublin whiskeys; production later relocated to Cork."
     :culture/url "https://en.wikipedia.org/wiki/Jameson_Irish_Whiskey"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "dublin.festival.bloomsday"
     :culture/name "Bloomsday"
     :culture/municipality "dublin"
     :culture/country "IRL"
     :culture/kind :festival
     :culture/summary "Commemoration and celebration of the life of Irish writer James Joyce, observed annually in Dublin and elsewhere on 16 June, named after Leopold Bloom, protagonist of Ulysses."
     :culture/url "https://en.wikipedia.org/wiki/Bloomsday"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "dublin.heritage.book-of-kells"
     :culture/name "Book of Kells"
     :culture/municipality "dublin"
     :culture/country "IRL"
     :culture/kind :heritage
     :culture/summary "Illustrated manuscript and Celtic Gospel book in Latin created c. 800 AD, bound in four volumes and on display to visitors in Trinity College Library, Dublin."
     :culture/url "https://en.wikipedia.org/wiki/Book_of_Kells"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

(defn spec-basis [muni] (get catalog muni))

(defn coverage
  ([] (coverage (keys catalog)))
  ([munis]
   (let [have (filter catalog munis)
         missing (remove catalog munis)]
     {:requested (count munis)
      :covered (count have)
      :covered-municipalities (vec (sort have))
      :missing-municipalities (vec (sort missing))
      :note (str "cloud-itonami-municipality-irl-dublin culture catalog "
                 "(ADR-2607171400): " (count (get catalog "dublin"))
                 " Dublin entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [muni kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis muni)))
