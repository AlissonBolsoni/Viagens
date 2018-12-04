package br.com.alisson.viagens.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.alisson.viagens.R
import br.com.alisson.viagens.model.Pacote
import br.com.alisson.viagens.utils.DiasUtil
import br.com.alisson.viagens.utils.MoedaUtil
import br.com.alisson.viagens.utils.ResoursesUtil
import kotlinx.android.synthetic.main.activity_resumo_compra.*
import java.math.BigDecimal

class ResumoCompraActivity : AppCompatActivity() {

    companion object {
        const val TITULO_APPBAR = "Resumo da Compra"
        const val PACOTE = "PACOTE"
    }

    private var pacote: Pacote? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumo_compra)

        title = TITULO_APPBAR

        pacote = intent.getSerializableExtra(ResumoPacoteActivity.PACOTE) as Pacote

        resumo_compras_data.text = DiasUtil.pegaDataViagem(pacote!!.dias)
        resumo_compras_local.text = pacote!!.local
        resumo_compras_valor.text = MoedaUtil.formataBR(pacote!!.preco)
        resumo_compras_imagem.setImageDrawable(ResoursesUtil.pegaDrawable(this, pacote!!.imagem))
    }
}
