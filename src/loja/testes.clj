(ns loja.testes)

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

(let [numero "0000 1111 2222 3333"
      cvv 000
      validade "2022-05"
      limite 1.000
      cliente "000.111.222-33"]
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

(println "\n -------------------------------- LISTAR CLIENTES, CARTÕES E COMPRAS --------------------------------")

(def clientes [{:nome "Feiticeira Escarlate" :cpf "000.111.222-33" :email "feiticeira.poderosa@vingadoras.com.br"}
               {:nome "Viúva Negra" :cpf "333.444.555-66" :email "viuva.casca.grossa@vingadoras.com.br"}
               {:nome "Hermione Granger" :cpf "666.777.888-99" :email "hermione.salvadora@hogwarts.com"}
               {:nome "Daenerys Targaryen" :cpf "999.123.456-78" :email "mae.dos.dragoes@got.com"}])

(def cartoes [{:numero "1234 1234 1234 1234" :cvv 111 :validade "2023-01" :limite 1.000 :cliente "000.111.222-33"}
              {:numero "4321 4321 4321 4321" :cvv 222 :validade "2024-02" :limite 2.000 :cliente "333.444.555-66"}
              {:numero "1598 1598 1598 1598" :cvv 333 :validade "2021-03" :limite 3.000 :cliente "666.777.888-99"}
              {:numero "3939 3939 3939 3939" :cvv 555 :validade "2026-05" :limite 5.000 :cliente "999.123.456-78"}])

(def compras [{:data "2022-01-01" :valor 129.90 :estabelecimento "Outback" :categoria "Alimentação" :cartao "1234 1234 1234 1234" }
              {:data "2022-01-02" :valor 260.00 :estabelecimento "Dentista" :categoria "Saúde" :cartao "1234 1234 1234 1234"}
              {:data "2022-02-01" :valor 20.00 :estabelecimento "Cinema" :categoria "Lazer" :cartao "1234 1234 1234 1234"}
              {:data "2022-01-10" :valor 150.00 :estabelecimento "Show" :categoria "Lazer" :cartao "4321 4321 4321 4321"}
              {:data "2022-02-10" :valor 289.99 :estabelecimento "Posto de gasolina" :categoria "Automóvel" :cartao "4321 4321 4321 4321"}
              {:data "2022-02-20" :valor 79.90 :estabelecimento "iFood" :categoria "Alimentação" :cartao "4321 4321 4321 4321"}
              {:data "2022-03-01" :valor 85.00 :estabelecimento "Alura" :categoria "Educação" :cartao "4321 4321 4321 4321"}
              {:data "2022-01-30" :valor 85.00 :estabelecimento "Alura" :categoria "Educação" :cartao "1598 1598 1598 1598"}
              {:data "2022-01-31" :valor 350.00 :estabelecimento "Tok&Stok" :categoria "Casa" :cartao "1598 1598 1598 1598"}
              {:data "2022-02-01" :valor 400.00 :estabelecimento "Leroy Merlin" :categoria "Casa" :cartao "1598 1598 1598 1598"}
              {:data "2022-03-01" :valor 50.00 :estabelecimento "Madero" :categoria "Alimentação" :cartao "6655 6655 6655 6655"}
              {:data "2022-03-01" :valor 70.00 :estabelecimento "Teatro" :categoria "Lazer" :cartao "6655 6655 6655 6655"}
              {:data "2022-03-04" :valor 250.00 :estabelecimento "Hospital" :categoria "Saúde" :cartao "6655 6655 6655 6655"}
              {:data "2022-04-10" :valor 130.00 :estabelecimento "Drogaria" :categoria "Saúde" :cartao "6655 6655 6655 6655"}
              {:data "2022-03-10" :valor 100.00 :estabelecimento "Show de pagode" :categoria "Lazer" :cartao "3939 3939 3939 3939"}
              {:data "2022-03-11" :valor 25.90 :estabelecimento "Dogão" :categoria "Alimentação" :cartao "3939 3939 3939 3939"}
              {:data "2022-03-12" :valor 215.87 :estabelecimento "Praia" :categoria "Lazer" :cartao "3939 3939 3939 3939"}
              {:data "2022-04-01" :valor 976.88 :estabelecimento "Oficina" :categoria "Automóvel" :cartao "3939 3939 3939 3939"}
              {:data "2022-04-10" :valor 85.00 :estabelecimento "Alura" :categoria "Educação" :cartao "3939 3939 3939 3939"}])


(defn todos-clientes
  []
  clientes)


(defn todos-cartoes
  []
  cartoes)


(defn todas-compras
  []
  compras)

(println "\n -------------------------------- TOTAL GASTO --------------------------------")

(defn total-gasto
  [compras]
  (->> compras (map :valor)
       (reduce +)))

(let [compras compras]
  (println (total-gasto compras)))

(println "\n -------------------------------- BUSCAR COMPRAS POR MÊS --------------------------------")

(defn mes-da-data [data]
  (second (re-matches #"\d{4}-(\d{2})-\d{2}" data)))

(defn filtra-compras
  [predicado compras]
  (vec (filter predicado compras)))

(defn busca-compras-por-mes
  [mes compras]
  (filtra-compras #(= mes (mes-da-data (:data %)))
                  compras))

(let [compras compras
      mes 3]
  (->> (busca-compras-por-mes mes compras)
       println))

(println "\n -------------------------------- BUSCAR COMPRAS POR ESTABELECIMENTO --------------------------------")

(defn busca-compras-por-estabelecimento [estabelecimento compras]
  (filtra-compras #(= estabelecimento (:estabelecimento %))
                  compras))

(let [compras compras estabelecimento "Alura"]
  (->> (busca-compras-por-estabelecimento estabelecimento compras)
       println))

(println "\n -------------------------------- CALCULAR O TOTAL DA FATURA DE UM MÊS --------------------------------")


(def total-gasto-no-mes (comp total-gasto busca-compras-por-mes))

(let [compras compras
      mes 3]
  (println (total-gasto-no-mes mes compras)))