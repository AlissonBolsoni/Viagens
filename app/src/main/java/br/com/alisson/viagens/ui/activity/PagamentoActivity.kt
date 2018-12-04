package br.com.alisson.viagens.ui.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.alisson.viagens.R
import br.com.alisson.viagens.model.Pacote
import br.com.alisson.viagens.utils.MoedaUtil
import kotlinx.android.synthetic.main.activity_pagamento.*
import java.math.BigDecimal

class PagamentoActivity : AppCompatActivity() {

    companion object {
        const val TITULO_APPBAR = "Pagamento"
        const val PACOTE = "PACOTE"
    }

    private var pacote: Pacote? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagamento)

        title = TITULO_APPBAR

        pacote = intent.getSerializableExtra(ResumoPacoteActivity.PACOTE) as Pacote

        pagamento_valor.text = MoedaUtil.formataBR(pacote!!.preco)

        pagamento_finalizar_compra.setOnClickListener {
            val it = Intent(this, ResumoCompraActivity::class.java)
            it.putExtra(ResumoCompraActivity.PACOTE, pacote!!)
            startActivity(it)

        }
    }
}
