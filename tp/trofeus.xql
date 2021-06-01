xquery version "1.0"; 
<html>
<body> 
<h2 style="color:#25A8C8;">Troféus por Jogador</h2> 
<ul> 
{ 
for $x in distinct-values(doc("C:/Users/isabe/Documents/GitHub/ID/tp/jogador.xml")//jogador/@nome) 
let $titulos := doc("C:/Users/isabe/Documents/GitHub/ID/tp/jogador.xml")//jogador[@nome=$x]/trofeus/trofeu/text() 
order by $x 
return 
		(<p/><b>Jogador {$x}</b>, 
		<ul> 
		{
			for $t in $titulos 
			order by $t 
			return <li>	{$t}</li> 
		} 
		</ul>) 
} 
</ul>
</body>
</html> 
