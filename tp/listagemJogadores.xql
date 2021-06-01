xquery version "1.0";
<html>
<body>
<h2>Listagem de jogadores</h2>
<table border ='11' cellpadding='10'>
<tr>
	<th>FOTO</th>
	<th>NOME</th>
	<th>DATA DE NASCIMENTO</th>
	<th>ALTURA</th>
	<th>PESO</th>
	<th>PÉ PREFERIDO</th>
	<th>POSIÇÃO</th>
</tr>
{
	for $x in doc("C:/Users/isabe/Documents/GitHub/ID/tp/jogador.xml")//jogador
	order by $x/@nome
	return <tr>
			<td><img src="{$x/foto}" width="80"/></td>
			<td>{$x/nomeCompleto}</td>
			<td>{$x/dataNascimento}</td>
			<td>{$x/altura}</td>
			<td>{$x/peso}</td>
			<td>{$x/pePreferido}</td>
			<td>{$x/posicao}</td>
	</tr>
}
</table>
</body>
</html>
