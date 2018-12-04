package br.com.alisson.viagens.utils

import java.math.BigDecimal
import java.text.DecimalFormat
import java.util.*

object MoedaUtil{

    private const val PT ="pt"
    private const val BR ="br"
    private const val ATUAL ="R$"
    private const val DESEJADO ="R$ "


    fun formataBR(valor: BigDecimal): String{
        val format = DecimalFormat.getCurrencyInstance(Locale(PT, BR))
        return (format.format(valor)).replace(ATUAL, DESEJADO)
    }

}
