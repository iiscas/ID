<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html">
	</xsl:output>
	<xsl:template match="jogadores">
		<html>
			<body>
				<h2>Listagem de jogadores</h2>
				<table border="1">
					<tr bgcolor="#98AFC7">
						<th style="text-align:left">Nome</th>
						<th style="text-align:left">Foto</th>
					</tr>
					<xsl:apply-templates select="jogador">
						<xsl:sort select="@nome">
						</xsl:sort>
					</xsl:apply-templates>
				</table>
			</body>
		</html>
	</xsl:template>
	<xsl:template match="jogador">
		<tr>
			<td>
				<xsl:value-of select="@nome">
				</xsl:value-of>
			</td>
			<td>
				<img src="{foto}" width="100">
				</img>
			</td>
		</tr>
	</xsl:template>
</xsl:stylesheet>
