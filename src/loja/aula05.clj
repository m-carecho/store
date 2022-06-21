(ns loja.aula05
  (:require [loja.db :as l.db]
            [loja.logic :as l.logic]))

(defn gastou-bastante? [info-do-usuairo]
  (> (:preco-total info-do-usuairo) 500))

(let [pedidos (l.db/todos-os-pedidos)
      resumo (l.logic/resumo-por-usuario pedidos)]
  (println "keep" (keep gastou-bastante? resumo)))

(println (range 10))
(println (take 2 (range 1000000000000000)))
; a sequenca nao esta sendo "gulosa" (eager)

(let [sequencia (range 1000000)]
  (println (take 2 sequencia))
  (println (take 2 sequencia)))                             ;imutabilidade, sequencia eh a mesma
; esta sendo LAZY (preguiçosa)

(defn filtro1 [x]
  (println "filtro1" x)
  x)


(defn filtro2 [x]
  (println "filtro2" x)
  x)

(->> (range 10)
     (map filtro1)
     (map filtro2)
     println)

;CHUNKS de 32
(->> (range 50)
     (map filtro1)
     (map filtro2)
     println)

(->> (range 50)
     (mapv filtro1)
     (mapv filtro2)
     println)

;Lista ligada foi 100% lazy nesse cenario
(->> '(0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0)
     (map filtro1)
     (map filtro2)
     println)


(defn str->long [valor]
  (Long/parseLong (clojure.string/replace valor #" " "")))

(println "\n -------------------------------- NOVO CLIENTE --------------------------------")

(defn novo-cliente [nome cpf email]
  {:nome  nome
   :cpf   cpf
   :email email})

(let [nome "Milena"
      cpf "123.456.789.09"
      email "milena@teste.com"]
  (println (novo-cliente nome cpf email)))


(println "\n -------------------------------- NOVO CARTAO --------------------------------")

(defn novo-cartao
  [numero cvv validade limite cliente]
  {:numero (str->long numero)
   :cvv (str->long cvv)
   :email   validade
   :limite  (bigdec limite)
   :cliente cliente})

(let [numero "1111 2222 3333 4444"
      cvv 555
      validade "2022-09"
      limite 5.000
      ;cliente "114.918.436-16"
      cliente "000.111.222-33"
      ]
  (println (novo-cartao numero cvv validade limite cliente)))



(println "\n -------------------------------- NOVA COMPRA --------------------------------")

(defn nova-compra
  [data valor estabelecimento categoria cartao]
  {:data data
   :valor (str->long valor)
   :estabelecimento estabelecimento
   :categoria categoria
   :cartao cartao})

(let [data "2022-05-19"
      valor 120
      estabelecimemto "cobasi"
      categoria "pet"
      cartao "0000 1111 2222 3333"]
  (println (nova-compra data valor estabelecimemto categoria cartao)))