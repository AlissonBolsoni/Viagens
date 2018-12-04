package br.com.alisson.viagens.ui.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.alisson.viagens.R
import br.com.alisson.viagens.model.Pacote
import br.com.alisson.viagens.utils.DiasUtil
import br.com.alisson.viagens.utils.MoedaUtil
import br.com.alisson.viagens.utils.ResoursesUtil
import kotlinx.android.synthetic.main.activity_resumo_pacote.*
import java.math.BigDecimal

class ResumoPacoteActivity : AppCompatActivity() {

    companion object {
        const val TITLE_APP = "Resumo Pacote"
        const val PACOTE = "PACOTE"
    }

    private var pacote: Pacote? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumo_pacote)

        title = TITLE_APP

        pacote = intent.getSerializableExtra(PACOTE) as Pacote

        resumo_imagem.setImageDrawable(ResoursesUtil.pegaDrawable(this, pacote!!.imagem))
        resumo_dias.text = DiasUtil.formataDiasEmTexto(pacote!!.dias)
        resumo_local.text = pacote!!.local
        resumo_preco.text = MoedaUtil.formataBR(pacote!!.preco)
        resumo_data.text = DiasUtil.pegaDataViagem(pacote!!.dias)

        resumo_realizar_pagamento.setOnClickListener {
            val it = Intent(this, PagamentoActivity::class.java)
            it.putExtra(PagamentoActivity.PACOTE, pacote!!)
            startActivity(it)
        }

    }
}
