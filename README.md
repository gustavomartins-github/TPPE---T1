# TRABALHO 03 - TRABALHO FINAL (FGA0242 - TPPE)

<p align='justify'> 
O Trabalho 3 referente à disciplina de TPPE (Técnicas de Programação em Plataformas Emergentes - UnB Gama) consiste em responder duas perguntas, baseando-se no <a href="https://github.com/andrelanna/fga0242/tree/master/tps/tp2">enunciado</a> do Trabalho 3. Diante disso, o <strong>tópico 1</strong> do presente documento apresenta alguns pontos relevantes do enunciado, enquanto o <strong>tópico 2</strong> é responsável por apresentar tais perguntas. Em seguida, o <strong>tópico 3</strong> traz informações relevantes sobre a construção das respostas. Por sua vez, o <strong>tópico 4</strong> é responsável por apresentar as informações gerais sobre o trabalho, como deadline e formato de entrega. Por fim, o <strong>tópico 5</strong> apresenta as referências bibliográficas utilizadas para a realização das respostas. 
</p>

<br>

# 1. SOBRE O ENUNCIADO

<p align = "justify">Segundo o <a href="https://github.com/andrelanna/fga0242/tree/master/tps/tp2">enunciado</a> do trabalho 3, disponibilizado pelo <a href="https://github.com/andrelanna">professor</a>, existem 8 principais <u>princípios de um bom projeto de código</u>. A <strong>Tabela 1</strong> a seguir relaciona tais princípios com uma breve descrição de cada um.
</p>
<br>
<table align='center'>
<colgroup>
    <col style="background-color: #722f37" />
    <col span="2" />
</colgroup>
<tr>
    <th>PRINCÍPIO</th>
    <th>DESCRIÇÃO</th>
</tr>
<tr>
    <th>Simplicidade</th>
    <th>Um código simples é fácil de entender, testar e modificar. A simplicidade evita complicações desnecessárias e mantém o foco no que realmente importa, reduzindo a chance de erros.</th>
</tr>
<tr>
    <th>Elegância</th>
    <th>Um código elegante resolve problemas de maneira clara e eficiente, usando apenas o necessário. Ele é esteticamente agradável, combinando forma e função de modo que as soluções pareçam naturais.</th>
</tr>
<tr>
    <th>Modularidade</th>
    <th>Modularidade se refere à divisão do software em partes menores e independentes (módulos), cada uma com uma função específica. Isso facilita a manutenção, a extensão e o entendimento do sistema.</th>
</tr>
<tr>
    <th>Boas Interfaces</th>
    <th>Boas interfaces definem claramente como os diferentes módulos ou componentes do sistema interagem. Elas devem ser simples, intuitivas e consistentes, permitindo o uso correto e minimizando erros.</th>
</tr>
<tr>
    <th>Extensibilidade</th>
    <th>Extensibilidade é a capacidade de um sistema ser facilmente expandido ou modificado para atender novas necessidades, sem impactar negativamente o restante do sistema.</th>
</tr>
<tr>
    <th>Evitar Duplicação</th>
    <th>Evitar duplicação significa minimizar a repetição de código e lógica. A duplicação aumenta o risco de erros e torna o código mais difícil de manter. O princípio DRY (Don't Repeat Yourself) é fundamental aqui.</th>
</tr>
<tr>
    <th>Portabilidade</th>
    <th>Portabilidade se refere à facilidade com que o software pode ser transferido e executado em diferentes ambientes ou plataformas. Um código portátil é adaptável e versátil.</th>
</tr>
<tr>
    <th>Código deve ser Idiomático e bem Documentado</th>
    <th>Um código idiomático segue as convenções da linguagem utilizada, facilitando a leitura e a manutenção. Além disso, deve ser bem documentado para que outros desenvolvedores possam entender seu propósito e funcionamento.</th>
</tr>
</table>

<br>

# 2. SOBRE AS PERGUNTAS A SEREM RESPONDIDAS

<p align = "justify">

De acordo com o <a href = "https://github.com/andrelanna/fga0242/tree/master/tps/tp2">enunciado</a>, as seguintes perguntas devem ser respondidas:

<ol>
<li><i>"Para cada um dos princípios de bom projeto de código mencionados acima, apresente sua definição e relacione-o com os maus-cheiros de código apresentados por Fowler em sua obra."</i></li>
<br>
<li><i>"Identifique quais são os maus-cheiros que persistem no trabalho prático 2 do grupo, indicando quais os princípios de bom projeto ainda estão sendo violados e indique quais as operações de refatoração são aplicáveis. Atenção: não é necessário aplicar as operações de refatoração, apenas indicar os princípios violados e operações possíveis de serem aplicadas."</i>
</li>
</ol>

Diante disso, é importante ressaltar que o enunciado se faz extermamente útil para responder a <strong>pergunta 1</strong>, visto que nele há uma listagem dos "<i>princípios de bom projeto de código</i>" mencionados pela pergunta, o que justifica a criação do tópico 2 do presente documento. Somado a isso, essa mesma pergunta precisa de um estudo prévio sobre os "<i>maus-cheiros de código</i>" presentes na obra <strong>Refactoring: Improving the Design of Existing Code</strong>, escrita pelo britânico <a href = "https://www.martinfowler.com/">Martin Fowler</a>

Por outro lado, a pergunta 2 se mostra mais complexa, sendo uma boa estrátegia para sua resolução a divisão da complexidade em módulos menores de atividades. São eles:
<ol>
<li>Identificar os <strong>maus-cheiros</strong> que persistem no tabalho prático 2.</li>
<li>Indicar quais são os <u>princípios de bom projeto</u> que <strong>permanecem  sendo violados</strong> no <strong>trabalho prático 2</strong>. (Tais princípios podem ser facilmente consultados pela <strong>Tabela 1</strong> no tópico 2 desse documento.)</li>
<li>Indicar quais operações de refatoração são aplicáveis para resolver os maus-cheiros de código identificados na <storng>atividade 1.</strong></li>
</ol> 
</p>

<br>

# 3. SOBRE AS RESPOSTAS

<p align = "justify">
As respostas às duas perguntas exigem uma análise detalhada e uma aplicação dos conceitos de bom projeto de código e refatoração. Para responder à primeira pergunta, será realizada uma associação entre cada princípio de bom projeto de código e os maus-cheiros de código identificados por Fowler. Isso envolverá a compreensão dos problemas que cada mau-cheiro pode causar e como os princípios podem ajudar a mitigá-los.

Para a segunda pergunta, será realizada uma análise crítica do trabalho prático 2, identificando os maus-cheiros que ainda persistem e indicando quais princípios de bom projeto estão sendo violados. Em seguida, serão sugeridas operações de refatoração que poderiam ser aplicadas para melhorar a qualidade do código, conforme os princípios destacados. Essa análise será baseada nos princípios descritos na <strong>Tabela 1</strong> e nas práticas de refatoração de Fowler.

</p>

<br>

# 4. INFORMAÇÕES GERAIS DO TRABALHO

<p align = "justify">

Segundo o <a href = "https://github.com/andrelanna/fga0242/tree/master/tps/tp2">enunciado</a> do trabalho 3, além de responder as duas perguntas evidenciadas no <strong>tópico 3</strong> do presente documento, o trabalho deve atender as seguintes cláusulas:

<ol>
<li>O trabalho deverá ser entregue na forma de um <strong>relatório PDF</strong></li>
<li>O trabalho deverá ser enviado ao <strong>repositório utilizado pelos trabalhos 1 e 2</strong> da disciplina</li>
<li>A deadline (data limite de entrega) é dia <strong>15/08/2024</strong>, até <strong>23h50min</strong>.</li>
</ol>

Diante disso, considerando que o atual repositório foi utilizado para realização dos dois trabalhos (<a href = "https://github.com/gustavomartins-github/TPPE_Trabalhos/tree/T1_TDD">trabalho 1</a> sobre a técnica TDD e <a href = "https://github.com/gustavomartins-github/TPPE_Trabalhos/tree/T2_refactoring">trabalho 2</a> sobre refatoração), o <a href = "https://github.com/gustavomartins-github/TPPE_Trabalhos/tree/T3_SoftwareProject">trabalho 3</a> (atual) econtra-se também neste repositório, respeitando a política de organização do projeto a qual pode ser encontrada na <a href = "https://github.com/gustavomartins-github/TPPE_Trabalhos/tree/main">apresentação do repositório</a>.
</p>

<br>

# 5. REFERÊNCIAS BIBLIOGRÁFICAS

- Martin Fowler. Refactoring: Improving the design of Existing Code. Addison-Wesley Professional, 1999.

- Pete Goodliffe. Code Craft: The practice of Writing Excellent Code. No Starch Press, 2006.

