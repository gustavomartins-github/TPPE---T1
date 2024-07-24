# TRABALHO 01 (FGA0242 - TPPE)

<p align='justify'> 
O trabalho 2 referente a disciplina de TPPE (Técnicas de Programação em Plataformas Emegentes - UnB Gama) consiste em aplicar algumas técnicas específicas de refatoração sobre determinados métodos/classes do trabalho anterior, o qual consistiu em desenvolver uma aplicação em java sobre comércio varejista de bens de consumo. Por fim, o trabalho atual deve atender as seguintes cláusulas:
</p>

<ol>
  <li>Linguagem de programação: Java</li>
  <li>Frarmework de Teste: JUnit 4</li>
  <li>A switch de teste definida no trabalho anterior deve continuar retornando verde</li>
  <li><strong>Após aplicar uma técnica de refatoração, é necessário criar um comentário no código descrevendo os efeitos da operação de refatoração no código</strong></li>
</ol>
<p align = "justify"><strong>Obs.:</strong> deadline será daqui duas semanas (contabilizando a partir do dia 24/07)</p> 

<p>
Diante do exposto, a <strong><i>Tabela 1</i></strong> a seguir sintetiza as informações dos integrantes do grupo. Observe que o grupo continuar com os mesmo integrantes do trabalho anterior.
</p>

<table align='center'>
<colgroup>
    <col style="background-color: #722f37" />
    <col span="2" />
</colgroup>
<tr>
    <th>ID</th>
    <th>NOME</th>
    <th>MATRÍCULA</th>
    <th>FOTO</th>
</tr>
<tr>
    <td>1</td>
    <td align='center'><a href = "https://github.com/gustavomartins-github">Gustavo Martins Ribeiro</a></td>
    <td>200019228</td>
    <td align='center'><img src="https://github.com/gustavomartins-github.png" width = 50%></t>
</tr>
<tr>
    <td>2</td>
    <td><a href = "https://github.com/PabloChristianno">Pablo Christianno Silva Guedes</a></td>
    <td>200042416</td>
    <td align='center'><img src="https://github.com/PabloChristianno.png" width = 50%></t>
</tr>
<tr>
    <td>3</td>
    <td align='center'><a href = "https://github.com/PhilipeSousa">Philipe de Sousa Barros</a></td>
    <td>170154319</td>
    <td align='center'><img src="https://github.com/PhilipeSousa.png" width = 50%></t>
</tr>
<tr>
    <td>4</td>
    <td align='center'><a href = "https://github.com/deivid-a1">Deivid Alves de Carvalho</a></td>
    <td>190026758</td>
    <td align='center'><img src="https://github.com/deivid-a1.png" width = 50%></t>
</tr>
</table>


# SOBRE A REFATORAÇÃO

<p align = "justify">Segundo o <a href="https://github.com/andrelanna/fga0242/tree/master/TP">enunciado do problema</a>, disponibilizado pelo <a href="https://github.com/andrelanna">professor</a>, todos os grupo deverão aplicar as seguintes técnicas de refatoração:
</p>

<ol>
    <li><strong>Extrair Método</strong>: consiste em identificar um conjunto de instruções dentro de um método e movê-las para um novo método separado. Isso melhora a legibilidade, promove a reutilização do código e facilita a manutenção.</li>
    <li><strong>Extrair Classe</strong>: envolve identificar uma parte significativa de funcionalidades dentro de uma classe existente e movê-las para uma nova classe separada. Isso ajuda a organizar melhor o código, reduzindo a complexidade da classe original e promovendo uma melhor estruturação do sistema.</li>
    <li><strong>Substituir método por objeto-método</strong>: nesse caso, um método de uma classe é transformado em um objeto de uma nova classe, onde o método original é movido como um método desse novo objeto. Isso pode ser útil quando há necessidade de manter estado entre chamadas de método ou para encapsular lógicas complexas de maneira mais organizada.</li>
</ol>

<br>

<p align = "justify"> Somado a isso, de acordo com o <a href = "https://docs.google.com/spreadsheets/u/0/d/1uxbsT91bAKWi4LzTqbHanMdDl3pMxNhFTGA7i0EhN5E/htmlview#gid=0">formulário dos grupos</a>, nosso grupo é identificado pelo grupo 17, logo devemos aplicar as tecnicas apresentadas acima nos seguintes métodos/classe:</p>

<br>
<table align='center'>
<colgroup>
    <col style="background-color: #722f37" />
    <col span="2" />
</colgroup>
<tr>
    <th>MÉTODO DE REFATORAÇÃO</th>
    <th>CLASSE</th>
    <th>MÉTODO</th>
</tr>
<tr>
    <th>Extrair Método</th>
    <th>VENDA</th>
    <th>calcularTotal()</th>
</tr>
<tr>
    <th>Extrair Classe/Superclasse</th>
    <th>CLIENTE</th>
    <th>não se aplica</th>
</tr>
<tr>
    <th>Substituir método por objeto-método</th>
    <th>CLIENTE</th>
    <th>calcularTotal(), resultante da refatoração extrair método</th>
</tr>
</table>

# SOBRE A CORREÇÃO DO PROFESSOR

<p align = "justify">O professor atribuirá nota de acordo com a seguinte distruibuição</p>

<table align='center'>
<colgroup>
    <col style="background-color: #722f37" />
    <col span="2" />
</colgroup>
<tr>
    <th>MÉTODO DE REFATORAÇÃO</th>
    <th>VALOR</th>
</tr>
<tr>
    <th>Extrair Método</th>
    <th>25%</th>
</tr>
<tr>
    <th>Extrair Superclasse</th>
    <th>25%</th>
</tr>
<tr>
    <th>Substituir método por objeto-método</th>
    <th>50%</th>
</tr>
<table>

# MODELAGEM

<p align = "justify">
A seguir, para fins de revisão, observe o Diagrama de Classes UML do projeto.
</p>

<br>
<figure align = "center">
    <img src="img/Diagrama de Classes UML.png" width=100%>
</figure>
<p align = "center"><strong>Imagem 1</strong>: artefato <i>Diagrama de Classes UML</i> <br>Ref.: autoria própria. (Desenvolvido em <a href = 'https://www.lucidchart.com/pages/pt/landing'>Lucidchart</a>)</p>

