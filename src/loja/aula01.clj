(ns loja.aula01)

;vetor ["daniela" "guilherme" "carlos"]
;mapa {"guilherme" 37, "paulo" 39}
;lista ligada '(1 2 3 4 5 )
;ou tem 0 ou 1 [[0 1]]
;conjunto (não repete elemento) #{}

;map - passar po rvarios elementos de um vetor fazendo algo com cada um deles e e retornando o resultado dessa execução pra cada um deles
;reduce - reduzir eles a um resultado
;filter - filtrar eles
;Utilizar a função do para rodar tudo que está dentro do if
;Utilizar a função recur para dizer que estamos fazendo uma recursão

(map println ["daniela" "guilherme" "carlos"])
;first o primeiro do vetor
;rest o resto da sequencia - rest vazio retorna uma sequencia vazia
;next - next rest vazio retorna nulo - pode ser usado pra saber quando acabou
;seq - transforma em sequencia
;reucr - a ultima coisa a se fdazer antes de retornar a funcao, tb pode ser no else
(println (first ["daniela" "guilherme" "carlos"]))
(println (rest ["daniela" "guilherme" "carlos"]))
(println (next ["daniela" "guilherme" "carlos"]))

(println "\n\n\nMeu Mapa")

;tail recursion
(defn meu-mapa
  [funcao sequencia]
  (let [primeiro (first sequencia)]
    (if (not (nil? primeiro))
      (do
        (funcao primeiro)
        (recur funcao (rest sequencia))))))

(meu-mapa println ["daniela" "guilherme" "carlos"])