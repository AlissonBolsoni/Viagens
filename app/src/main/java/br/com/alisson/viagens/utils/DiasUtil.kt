package br.com.alisson.viagens.utils

object DiasUtil {

    private const val PLURAL =" dias"
    private const val SINGULAR =" dia"

    fun formataDiasEmTexto(dias: Int): String{
        return if(dias > 1) "$dias $PLURAL" else "$dias $SINGULAR"
    }

}