# Conversor CSV

    Este projeto foi realizado com o objetivo de aprimorar o conhecimento na linguagem Java.

## :zap: Descrição
   O objetivo deste projeto, foi elaborar um programa em Java capaz de converter os arquivos gerados pela página web (**arquivos de entrada**) para o formato requerido pelo subsistema e enviá-los para um **arquivo de saída**.

### :pushpin: Descrição dos arquivos de entrada e saída
   Os arquivos CSV gerados pela página web estão disponíveis na pasta `entradas`, estando separados por estado. 
   
   - Por exemplo: `sp.csv`, `mg.csv`, `ba.csv`...
   
   Para cada arquivo contido na pasta `entradas`, foi criado um arquivo correspondente com o mesmo nome na pasta `saidas`.
   
#### :stop_sign:	Foram garantidas as seguintes condições a respeito dos arquivos de **entrada**:
  - Toda data de nascimento está em formato brasileiro: `dd/mm/aaaa`
  - Todo email é válido
  - Todo CPF é válido e composto por exatamente 11 dígitos decimais (sem ponto nem hífen)

#### :stop_sign:	A formatação requerida para os arquivos de saída foi a seguinte:
  - O cabeçalho deveria ser o mesmo dos arquivos de entrada.
  - Os nomes completos dos inscritos deveriam ser padronizados todos em letras maiúsculas (acentos gráficos devem ser mantidos).
  - As datas de nascimento deveriam estar no formato ISO-8601: `aaaa-mm-dd`.
  - Os números de CPF deveriam estar corretamente formatados com ponto e hífen. Exemplo: `123.456.789-09`.

  As linhas dos arquivos de saída foram dispostas na mesma ordem que as dos arquivos de entrada.


### :balloon:	Exemplo
  Para o arquivo de entrada a seguir: `entradas/sp.csv`
  ```
    Nome completo,Data de nascimento,Email,CPF
    IRANI TAPEREBÁ,29/06/2001,tapereba@gmail.com,81627775471
    catarina mafra,28/05/1991,cmafra@gmail.com,75157671466
    bento naves,25/12/1993,b.naves@aol.com,88826690685
    Lurdes Neves,08/04/1985,lurdes.neves85@verizon.net,92277079138
  ```

  Foi produzido o seguinte arquivo de saída: `saidas/sp.csv`
  ```
    Nome completo,Data de nascimento,Email,CPF
    IRANI TAPEREBÁ,2001-06-29,tapereba@gmail.com,816.277.754-71
    CATARINA MAFRA,1991-05-28,cmafra@gmail.com,751.576.714-66
    BENTO NAVES,1993-12-25,b.naves@aol.com,888.266.906-85
    LURDES NEVES,1985-04-08,lurdes.neves85@verizon.net,922.770.791-38
  ```






## Instalação do projeto em sua máquina
  1. Clone o repositório
   
     `git@github.com:analuisams99/conversor-csv.git`
    
  2. Entre no diretório do repositório que você acabou de clonar:
  
     `cd conversor-csv`

  3. Instale as dependências:
    
     `mvn install`

## Para testar o projeto
  1. digite o comando no seu terminal
      
      `mvn test`
      
    Os códigos de testes, da pasta src/test/java/com/trybe/acc/java/conversorcsv, foram desenvolvidos pela Trybe.
    
---

-- Projeto desenvolvido por Ana Luisa Marques Simões, para fins didáticos. 2023
