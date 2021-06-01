<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes">
	</xsl:output>
	<xsl:template match="jogadores">
		<jogadores>
			<xsl:for-each select="jogador">
				<xsl:sort select="valorContrato" order="descending">
				</xsl:sort>
				<xsl:if test="position() &lt; 6">
				<jogador>
					<nome>
						<xsl:value-of select="@nome">
						</xsl:value-of>
					</nome>
					<preco>
					<xsl:value-of select="valorContrato">
					</xsl:value-of>
					</preco>
					
					</jogador>
				</xsl:if>
			</xsl:for-each>
		</jogadores>
	</xsl:template>
</xsl:stylesheet>
