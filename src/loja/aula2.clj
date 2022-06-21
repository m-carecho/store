(ns loja.aula02)

;vetor ["daniela" "guilherme" "carlos"]

(defn conta

  ([elementos]
  (conta 0 elementos))

  ([total-ate-agora elementos]
  (if (seq elementos)
    (recur (inc total-ate-agora) (next elementos))
    total-ate-agora)))

(println (conta ["daniela" "guilherme" "carlos"]))


(println "\n\nmudou aqui")
(defn contas
  [elementos]
  (loop [total-ate-agora 0
         elementos-restantes elementos]
    (if (seq elementos-restantes)
      (recur (inc total-ate-agora) (next elementos-restantes))
             total-ate-agora)))

(println (contas ["daniela" "guilherme" "carlos"]))
(println (contas []))