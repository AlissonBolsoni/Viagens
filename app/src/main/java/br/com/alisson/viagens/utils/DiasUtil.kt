package br.com.alisson.viagens.utils

import java.text.SimpleDateFormat
import java.util.*

object DiasUtil {

    private const val PLURAL =" dias"
    private const val SINGULAR =" dia"

    private val sdf = SimpleDateFormat("dd/MM", Locale.getDefault())

    fun formataDiasEmTexto(dias: Int): String{
        return if(dias > 1) "$dias $PLURAL" else "$dias $SINGULAR"
    }

    fun pegaDataViagem(dias: Int): String{

        val ida = Calendar.getInstance()
        val volta = Calendar.getInstance()
        volta.add(Calendar.DATE, dias)

        return "${sdf.format(ida.time)} - ${sdf.format(volta.time)} de ${volta.get(Calendar.YEAR)}"

    }

}