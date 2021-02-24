(ns cider-debugger-issue.core
  (:require [ring.adapter.jetty :as jetty]
            [clj-http.client :as http]))

(defn handler [request]
  (-> {:status 200
       :body "Hello World"}
      (assoc :headers {"Content-Type" "text/plain"})))

(defn start-server
  []
  (jetty/run-jetty handler {:port 3002}))

(comment
  (future (start-server))
  (http/get "http://localhost:3002"))


