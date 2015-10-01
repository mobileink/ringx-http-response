(ns ringx.middleware.http-response
  (:require [slingshot.slingshot :refer [try+]]))

(defn wrap-http-response
  [handler]
  (fn [request]
    (try+
      (handler request)
      (catch [:type :ringx.util.http-response/response] {:keys [response]}
        response))))

