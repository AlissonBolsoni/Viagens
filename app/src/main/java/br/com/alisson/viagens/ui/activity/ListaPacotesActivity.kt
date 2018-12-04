package br.com.alisson.viagens.ui.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.alisson.viagens.R
import br.com.alisson.viagens.dao.PacoteDAO
import br.com.alisson.viagens.model.Pacote
import br.com.alisson.viagens.ui.adaper.ListaPacotesAdapter
import kotlinx.android.synthetic.main.activity_lista_pacotes.*

class ListaPacotesActivity : AppCompatActivity() {

    companion object {
        const val TITULO_APPBAR = "Pacotes"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_pacotes)

        title = TITULO_APPBAR

        lista_pacotes_listview.adapter = ListaPacotesAdapter(this, PacoteDAO().lista())

        lista_pacotes_listview.setOnItemClickListener { _, _, position, _ ->

            val pacote = lista_pacotes_listview.getItemAtPosition(position) as Pacote
            val it = Intent(this, ResumoPacoteActivity::class.java)
            it.putExtra(ResumoPacoteActivity.PACOTE, pacote)
            startActivity(it)

        }
    }
}
