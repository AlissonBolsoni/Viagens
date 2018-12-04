package br.com.alisson.viagens.ui.adaper

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import br.com.alisson.viagens.R
import br.com.alisson.viagens.model.Pacote
import br.com.alisson.viagens.utils.DiasUtil
import br.com.alisson.viagens.utils.MoedaUtil
import br.com.alisson.viagens.utils.ResoursesUtil
import kotlinx.android.synthetic.main.item_pacote.view.*
import java.text.DecimalFormat
import java.util.*

class ListaPacotesAdapter(private val context: Context, private val pacotes: ArrayList<Pacote>) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var view = convertView
        if (view == null)
            view = LayoutInflater.from(context).inflate(R.layout.item_pacote, parent, false)

        val pacote = pacotes[position]
        view!!.item_pacote_local.text = pacote.local
        view.item_pacote_imagem.setImageDrawable(ResoursesUtil.pegaDrawable(context, pacote.imagem))
        view.item_pacote_dias.text = DiasUtil.formataDiasEmTexto(pacote.dias)
        view.item_pacote_preco.text = MoedaUtil.formataBR(pacote.preco)



        return view
    }

    override fun getItem(position: Int) = pacotes[position]

    override fun getItemId(position: Int) = 0L

    override fun getCount() = pacotes.size

}
