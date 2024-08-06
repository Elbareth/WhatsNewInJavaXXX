<?xml version = "1.0" encoding = "ISO-8859-1"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>
    <xsl:template match="/root">
        <table border = "1">
            <tr>
                <th>Who</th>
                <th>Remove</th>
                <th>Rocky</th>
            </tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>
    <xsl:template match="/root/who">
        <td><xsl:value-of select="@main"/><br/><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/root/remove">
        <td><xsl:value-of select="@swing"/><br/><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/root/rocky">
        <td><xsl:apply-templates/></td>
        <tr/>
    </xsl:template>
</xsl:stylesheet>