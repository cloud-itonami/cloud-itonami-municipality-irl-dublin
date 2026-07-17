(ns ordinance.facts
  "Municipal-ordinance compliance catalog for Dublin -- the
  FORTY-THIRD municipality-level entry (see cloud-itonami-municipality-jpn-tokyo,
  -usa-washington-dc, -gbr-london, -can-toronto, -deu-berlin, -fra-paris,
  -nld-amsterdam, -esp-madrid, -kor-seoul, -ita-roma, -aus-sydney,
  -arg-buenos-aires, -fin-helsinki, -dnk-copenhagen, -nor-oslo,
  -bel-brussels, -chl-santiago, -col-bogota, -cri-san-jose,
  -bra-sao-paulo, -ury-montevideo, -zaf-cape-town, -ecu-quito,
  -swe-gothenburg, -pry-asuncion, -mex-guadalajara, -fra-lyon,
  -ind-new-delhi, -pol-warsaw, -ken-nairobi, -tha-bangkok, -are-abu-dhabi,
  -vnm-hanoi, -idn-jakarta, -phl-manila, -egy-cairo, -tur-ankara,
  -nga-abuja, -sau-riyadh, -mys-kuala-lumpur, -aut-vienna, -che-bern for
  the first forty-two) per ADR-2607141700
  (cloud-itonami-compliance-fact-federation). Ireland's first entry
  across any of the 3 axes.

  Dublin is Ireland's stable capital, with no ongoing ambiguity.

  Ireland's official government domains (irishstatutebook.ie,
  dublincity.ie, gov.ie) all returned HTTP 403 on every URL tried, so
  this catalog's entries instead cite en.wikipedia.org, directly
  WebFetched and read (not merely WebSearch-cited).

  Municipal Corporations (Ireland) Act 1840 -- directly confirmed via
  en.wikipedia.org's Dublin City Council page, which states verbatim:
  'Under the Municipal Corporations (Ireland) Act 1840, they were
  replaced by a unicameral assembly. The name Dublin City Council was
  adopted for the unicameral assembly.' The first elected council
  convened October 1841 (the first Lord Mayor's name incidentally
  encountered but never persisted here).

  Local Government Act 2001 -- directly confirmed via the same
  Wikipedia page, which states verbatim: 'Local government in Dublin
  is regulated by the Local Government Act 2001.' Dublin Corporation
  became Dublin City Council on 1 January 2002, per the same source
  (used as :enacted-date, the most concretely-confirmed date
  available).

  An ordinance not in this table has NO spec-basis, full stop; extend
  `catalog`, do not invent an id/url/date.")

(def catalog
  "municipality-slug -> vector of ordinance entries."
  {"dublin"
   [{:ordinance/id "dublin.municipal-corporations-ireland-act-1840"
     :ordinance/title "Municipal Corporations (Ireland) Act 1840"
     :ordinance/municipality "dublin"
     :ordinance/country "IRL"
     :ordinance/kind :local-act
     :ordinance/number "1840"
     :ordinance/url "https://en.wikipedia.org/wiki/Dublin_City_Council"
     :ordinance/url-provenance :wikipedia-corroborated
     :ordinance/enacted-date "1840"
     :ordinance/retrieved-at "2026-07-17"
     :ordinance/topic #{:governance}}
    {:ordinance/id "dublin.local-government-act-2001"
     :ordinance/title "Local Government Act 2001"
     :ordinance/municipality "dublin"
     :ordinance/country "IRL"
     :ordinance/kind :local-act
     :ordinance/number "2001"
     :ordinance/url "https://en.wikipedia.org/wiki/Dublin_City_Council"
     :ordinance/url-provenance :wikipedia-corroborated
     :ordinance/enacted-date "2002-01-01"
     :ordinance/retrieved-at "2026-07-17"
     :ordinance/topic #{:governance}}]})

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
      :note (str "cloud-itonami-municipality-irl-dublin Wave 0 (ADR-2607141700): "
                 (count (get catalog "dublin")) " Dublin entries seeded "
                 "with Wikipedia citations (Ireland's official domains all 403'd). "
                 "Extend `ordinance.facts/catalog`, never fabricate an id/url.")})))

(defn by-topic [muni topic]
  (filterv #(contains? (:ordinance/topic %) topic) (spec-basis muni)))
