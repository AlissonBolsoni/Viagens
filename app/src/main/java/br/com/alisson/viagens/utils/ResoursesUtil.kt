package br.com.alisson.viagens.utils

import android.content.Context
import android.graphics.drawable.Drawable

object ResoursesUtil {

    private const val DRAWABLE ="drawable"

    fun pegaDrawable(context: Context, imagem: String): Drawable {

        return context.resources.getDrawable(context.resources.getIdentifier(imagem, DRAWABLE, context.packageName))

    }

}