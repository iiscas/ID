xquery version "1.0";

(: Generated with EditiX XML Editor (http://www.editix.com) at Mon May 31 21:36:50 BST 2021 :)

<JogadoresClube nome="{doc("C:/Users/isabe/Documents/GitHub/ID/tp/clube.xml")/clube}">
{
	for $x in doc("C:/Users/isabe/Documents/GitHub/ID/tp/jogador.xml")//jogador
	let $v := string(doc("C:/Users/isabe/Documents/GitHub/ID/tp/clube.xml")/clube)
	where contains($x/clubeAtual,$v)
	order by $x
	return <jogador>
		{($x/@nome)}
	</jogador>
}
</JogadoresClube>
