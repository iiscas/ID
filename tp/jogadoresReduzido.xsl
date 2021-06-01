<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="xml" indent="yes">
	</xsl:output>
	<xsl:template match="jogadores">
		<jogadores>
			<xsl:apply-templates select="jogador">
				<xsl:sort select="idade" data-type="number" order="ascending">
				</xsl:sort>
			</xsl:apply-templates>
		</jogadores>
	</xsl:template>
	<xsl:template match="jogador">
		<jogador>
			<nome>
				<xsl:value-of select="@nome">
				</xsl:value-of>
			</nome>
			<nacionalidade>
				<xsl:value-of select="nacionalidade">
				</xsl:value-of>
			</nacionalidade>
			<idade>
				<xsl:value-of select="idade">
				</xsl:value-of>
			</idade>
			<selecao>
				<xsl:value-of select="selecao">
				</xsl:value-of>
			</selecao>
			<xsl:for-each select="trofeus">
				<trofeu>
					<xsl:value-of select="trofeu">
					</xsl:value-of>
				</trofeu>
			</xsl:for-each>
		</jogador>
	</xsl:template>
</xsl:stylesheet>
