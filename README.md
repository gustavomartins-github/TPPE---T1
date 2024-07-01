# TRABALHO 01 (FGA0242 - TPPE)

<p align='justify'> 
O trabalho 1 referente a disciplina de TPPE (Técnicas de Programação em Plataformas Emegentes - UnB Gama) consiste em desenvolver uma aplicação em java sobre comércio varejista de bens de consumo. Por fim, o trabalho deve atender as seguintes cláusulas:
</p>

<ol>
  <li>Linguagem de programação: Java</li>
  <li>Frarmework de Teste: JUnit 4</li>
  <li>Todos os testes deverão ser triangulados utilizando a parametrização de testes oferecida pelo JUnit4</li>
</ol>

<p>
Diante do exposto, a <strong><i>Tabela 1</i></strong> a seguir sintetiza as informações dos integrantes do grupo:
</p>

<table>
<colgroup>
    <col style="background-color: #722f37" />
    <col span="2" />
</colgroup>
<tr>
    <th>ID</th>
    <th>NOME</th>
    <th>MATRÍCULA</th>
    <th></th>
</tr>
<tr>
    <td>1</td>
    <td><a href = "https://github.com/gustavomartins-github">Gustavo Martins Ribeiro</a></td>
    <td>200019228</td>
    <td><img src="https://github.com/gustavomartins-github.png" width = 50%></t>
</tr>
<tr>
    <td>2</td>
    <td><a href = "https://github.com/PabloChristianno">Pablo Christianno Silva Guedes</a></td>
    <td>200042416</td>
    <td><img src="https://github.com/PabloChristianno.png" width = 50%></t>
</tr>
<tr>
    <td>3</td>
    <td><a href = "https://github.com/PhilipeSousa">Philipe de Sousa Barros</a></td>
    <td>170154319</td>
    <td><img src="https://github.com/PhilipeSousa.png" width = 50%></t>
</tr>
<tr>
    <td>4</td>
    <td><a href = "https://github.com/deivid-a1">Deivid Alves de Carvalho</a></td>
    <td>190026758</td>
    <td><img src="https://github.com/deivid-a1.png" width = 50%></t>
</tr>
</table>

<p> 
A seguir, confira as regras de negócio para este projeto
</p>
<br></br>

# REGRAS DE NEGÓCIO

<p align='justify'>
Segundo o <a href = "https://github.com/andrelanna/fga0242/tree/master/TP">enunciado do problema</a>, o projeto consiste em um comércio varejista de bens de consumo e deve conter os seguintes elementos principais: clientes e compras. Dentro do universo de clientes, há 3 tipos principais: padrão, especial e prime. Agora sobre o universo de compras, há 2 tipos de imposto (ICMS e Imposto Municipal) que devem ser somados ao valor da compra total e o frete. Sendo assim, a <strong><i>Tabela 2</i></strong> a seguir sintetiza as informações sobre os clientes, enquanto a <strong><i>Tabela 3</i>apresenta as informações sobre compras</strong>
</p>

<ol>
  <li>Cliente</li>
        <p>Tabela contendo as clausulas e vantagens por tipo de cliente</p>
        <table>
        <colgroup>
            <col style="background-color: #006400" />
            <col span="2" />
        </colgroup>
        <tr>
            <th>TIPO</th>
            <th>CLAUSULA</th>
            <th>VANTAGENS</th>
        </tr>
        <tr>
            <td>Padrão</td>
            <td>nenhuma</td>
            <td>nenhuma</td>
        </tr>
        <tr>
            <td>Especial</td>
            <td>compra mensal > R$ 100,00</td>
            <td>
                <ol>
                <li>Desconto de 30% no frete</li>
                <li>Desconto de 10% sobre o valor total da compra</li>
                <li>Desconto de mais 10% se utilizar o cartão de crédito da empresa</li>
                </ol>
            </td>
        </tr>
        <tr>
            <td>Prime</td>
            <td>pagar mensalidade de R$20,00</td>
            <td>
            <ol>
                <li>Desconto de 100% no frete (frete = R$ 0,00)</li>
                <li>Cashback de R$ 0,03 por real gasto na loja</li>
                <li>Cashback de R$ 0,05 por real gasto caso use o cartão de crédito da empresa</li>
                <p><strong>Obs.:</strong> O valor <u>acumulado</u> de cashback pode ser utilizado como desconto em compras.</p>
                </ol>
            </td>
        </tr>
        </table>

  <li>Compras</li>
        <p>Tabela contendo as informações de imposto sobre a compra</p>
        <table>
        <colgroup>
            <col style="background-color: #993399" />
            <col span="2" />
        </colgroup>
        <tr>
            <th>TIPO</th>
            <th>CLIENTE DO DF</th>
            <th>CLIENTE FORA DO DF</th>
        </tr>
        <tr>
            <td>ICMS</td>
            <td>18%</td>
            <td>12%</td>
        </tr>
        <tr>
            <td>Imposto Municipal</td>
            <td>0%</td>
            <td>4%</td>
        </tr>
        </table>
        <br></br>
        <p>Tabela contendo as informações de frete que deve ser somado ao valor total da compra</p>
        <table>
        <colgroup>
            <col style="background-color: #000080" />
            <col span="2" />
        </colgroup>
        <tr>
            <th>REGIÃO</th>
            <th>CAPITAL</th>
            <th>INTERIOR</th>
        </tr>
        <tr>
            <td>Distrito Federal (DF)</td>
            <td>R$ 5,00</td>
            <td>R$ 0,00</td>
        </tr>
        <tr>
            <td>Regiao Centro-oeste</td>
            <td>R$ 10,00</td>
            <td>R$ 13,00</td>
        </tr>
        <tr>
            <td>Regiao Nordeste</td>
            <td>R$ 15,00</td>
            <td>R$ 18,00</td>
        </tr>
        <tr>
            <td>Regiao Norte</td>
            <td>R$ 20,00</td>
            <td>R$ 25,00</td>
        </tr>
        <tr>
            <td>Regiao Sudeste</td>
            <td>R$ 7,00</td>
            <td>R$ 10,00</td>
        </tr>
        <tr>
            <td>Regiao Sul</td>
            <td>R$ 10,00</td>
            <td>R$ 13,00</td>
        </tr>
        </table>
</ol>

<br></br>
# MODELAGEM

<p align='justify'>
Devido a quantidade de regras de negócio, foi acordado entre os membros a modelagem do projeto utilizando a Linguagem de Modelagem Unificada (UML) para a minimalização de eventuais erros estruturais, além de guiar nosso desenvolvimento. Somado a isso, vale ressaltar que o artefato <strong><i>Diagrama de Classes UML</i></strong> desenvolvido foi atualizado conforme a necessidade durante o desenvolvimento do projeto. Confira o artefato UML desenvolvido na <i><strong>imagem 1</strong></i> a seguir.
</p>

<figure align = "center">
    <img src="img/Diagrama de Classes UML.png" width=60%>
        <figcaption align = "center"><strong>Imagem 1</strong>: artefato <i>Diagrama de Classes UML</i> <br>
                Ref.: autoria própria. (Desenvolvido em <a href = 'https://www.lucidchart.com/pages/pt/landing'>Lucidchart</a>)
        </figcaption>
</figure>