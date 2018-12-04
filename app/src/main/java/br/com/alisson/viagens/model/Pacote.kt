package br.com.alisson.viagens.model

import java.io.Serializable
import java.math.BigDecimal

class Pacote(val local: String, val imagem: String, val dias: Int, val preco: BigDecimal): Serializable
