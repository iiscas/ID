xquery version "1.0";

for $x in doc("C:/Users/isabe/Documents/GitHub/ID/tp/jogador.xml")//jogador
	let $v := string(doc("C:/Users/isabe/Documents/GitHub/ID/tp/nacionalidade.xml")/nacionalidade)
	where contains($x/nacionalidade,$v)
	order by $x/nomeCompleto
return ("&#10;","Nome: ",  $x/nomeCompleto/text(), " -- ",$x/nacionalidade/text())
