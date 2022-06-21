(ns loja.aula4
  (:require [loja.db :as l.db]
            [loja.logic :as l.logic]))

(println (l.db/todos-os-pedidos))

(defn resumo-por-usuario-ordenado
  [pedidos]
  (->> pedidos
       l.logic/resumo-por-usuario
       (sort-by :preco-total)
       reverse))

(let [pedidos (l.db/todos-os-pedidos)
      resumo (resumo-por-usuario-ordenado pedidos)]
  (println "Resumo" resumo)
  (println "Ordenado" (sort-by :preco-total resumo))
  (println "Ordenado ao contrario" (reverse (sort-by :preco-total resumo)))
  (println "Ordenado por id" (sort-by :usuario-id resumo))

  (println (get-in pedidos [0 :itens :mochila :quantidade])))

(let [pedidos (l.db/todos-os-pedidos)
      resumo (resumo-por-usuario-ordenado pedidos)]
  (println "Resumo" resumo)
  (println "primeiro" (first resumo))
  (println "segundo" (second resumo))
  (println "resto" (rest resumo))
  (println "total" (count resumo))
  (println "Class" (class resumo))
  (println "nth 1" (nth resumo 1))
  (println "get 1" (get resumo 1))
  (println "take" (take 2 resumo)))

(defn top-2 [resumo]
  (take 2 resumo))

(let [pedidos (l.db/todos-os-pedidos)
      resumo (resumo-por-usuario-ordenado pedidos)]
  (println "Resumo" resumo)
  (println "top-2" (top-2 resumo)))

(let [pedidos (l.db/todos-os-pedidos)
      resumo (resumo-por-usuario-ordenado pedidos)]
  (println "> 500 filter =>" (filter #(> (:preco-total %) 500) resumo))
  (println "> 500 filter empty not =>" (not (empty?  (filter #(> (:preco-total %) 500) resumo))))
  (println "> 500 some =>" (some #(> (:preco-total %) 500) resumo)))
























