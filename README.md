# TRABALHO 02 (FGA0242 - TPPE)

<p align='justify'> 
O trabalho 2 referente a disciplina de TPPE (Técnicas de Programação em Plataformas Emegentes - UnB Gama) consiste em aplicar algumas técnicas específicas de refatoração sobre determinados elementos do trabalho anterior, o qual consistiu em desenvolver uma aplicação em java sobre comércio varejista de bens de consumo. Diante disso, durante a aplicação de cada técnica de refatoração, <a href = "https://github.com/gustavomartins-github/TPPE_Trabalhos/tree/T1_TDD/src/test">a suíte de teste estabelicida no trabalho 1</a> foi utilizada novamente <strong>a fim de verificar se a atividade de refetoração manteve o comportamento do elemento alvo</strong>. Não obstante, vale ressaltar que o presente documento é dividido em 3 tópicos principais. <strong>O primeio</strong> introduz cada técnica de refatoração e apresenta seu respectivo elemento alvo, isto é, a classe e/ou o método que será refatorado. Logo em seguida, <strong>o segundo</strong> tópico apresenta a distribuição de notas estipulada pelo professor frente a aplicação cada uma das técnicas de refatoração. Por fim, <strong>o terceiro e último tópico</strong> apresenta a evolução do artefato Diagrama de Classes UML, o qual foi desenvolvido inicialmente no trabalho anterior.
</p>

<br>

# 1. SOBRE A REFATORAÇÃO

<p align = "justify">Segundo o <a href="https://github.com/andrelanna/fga0242/tree/master/tps/tp1">enunciado do problema</a>, disponibilizado pelo <a href="https://github.com/andrelanna">professor</a>, todos os grupo deverão aplicar as seguintes técnicas de refatoração:
</p>

<ol>
    <li><strong>Extrair Método</strong>: consiste em identificar um conjunto de instruções dentro de um método e movê-las para um novo método separado. Isso melhora a legibilidade, promove a reutilização do código e facilita a manutenção.</li>
    <li><strong>Extrair Classe</strong>: envolve identificar uma parte significativa de funcionalidades dentro de uma classe existente e movê-las para uma nova classe separada. Isso ajuda a organizar melhor o código, reduzindo a complexidade da classe original e promovendo uma melhor estruturação do sistema.</li>
    <li><strong>Substituir método por objeto-método</strong>: nesse caso, um método de uma classe é transformado em um objeto de uma nova classe, onde o método original é movido como um método desse novo objeto. Isso pode ser útil quando há necessidade de manter estado entre chamadas de método ou para encapsular lógicas complexas de maneira mais organizada.</li>
</ol>

<br>

<p align = "justify"> Somado a isso, de acordo com o <a href = "https://docs.google.com/spreadsheets/u/0/d/1uxbsT91bAKWi4LzTqbHanMdDl3pMxNhFTGA7i0EhN5E/htmlview#gid=0">formulário dos grupos</a>, nosso grupo é identificado pelo grupo <strong>27</strong>, logo devemos aplicar as tecnicas apresentadas acima nos seguintes métodos/classe:</p>

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
    <th>calcularFrete()</th>
</tr>
<tr>
    <th>Extrair Classe/Superclasse</th>
    <th>CLIENTE</th>
    <th>não se aplica</th>
</tr>
<tr>
    <th>Substituir método por objeto-método</th>
    <th>VENDA</th>
    <th>calcularTotal()</th>
</tr>
</table>

<br>

# 2. SOBRE A CORREÇÃO DO PROFESSOR

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

<br>

# 3. MODELAGEM

<p align = "justify">
De acordo com as novas classes criadas e outras modificações resultantes das aplicações das técnicas de refatoração, o artefato Diagrama de Classes foi atualizado para comportar as evoluções. Tais alterações podem ser verificadas pela <strong>Imagem 1</strong> a seguir.
</p>

<br>
<figure align = "center">
    <img src="img/Diagrama de Classes UML.png" width=100%>
</figure>
<p align = "center"><strong>Imagem 1</strong>: segunda versão do artefato <i>Diagrama de Classes UML</i> <br>Ref.: autoria própria. (Desenvolvido em <a href = 'https://www.lucidchart.com/pages/pt/landing'>Lucidchart</a>)</p>

