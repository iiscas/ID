<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="text"/>
	<xsl:template match="jogadores">
		<xsl:text>--LISTAGEM DE JOGADORES--
</xsl:text>
		<xsl:apply-templates select="jogador">
			<xsl:sort select="nomeCompleto"/>
		</xsl:apply-templates>
	</xsl:template>
	<xsl:template match="jogador">
		<xsl:text>
</xsl:text>
		<xsl:value-of select="@nome"/>
		<xsl:text>
</xsl:text>
		<xsl:value-of select="estadoAtual"/>
		<xsl:text>
</xsl:text>
		<xsl:value-of select="clubeAtual"/>
		<xsl:text>
</xsl:text>
	</xsl:template>
</xsl:stylesheet>
