package com.example.testerecyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageButton
import androidx.recyclerview.widget.RecyclerView
import com.example.testerecyclerview.R
import com.example.testerecyclerview.model.Restaurante

class RestauranteAdapter(
    val context: Context,
    val mData: List<Restaurante>,
    val restauranteItemClickListener: RestauranteItemClickListener
): RecyclerView.Adapter<RestauranteAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): MyViewHolder {

        var view: View = LayoutInflater.from(context).inflate(
            R.layout.item_restaurante,
            viewGroup,
            false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.nome.text = mData[position].nome
        holder.endereco.text = mData[position].endereco
        holder.horarioFuncionamento.text = mData[position].horarioFuncionamento
    }

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var nome: TextView
        var endereco: TextView
        var horarioFuncionamento: TextView
        var btnProcurar: Button

        init {
            nome = itemView.findViewById(R.id.tv_nome_restaurante)
            endereco = itemView.findViewById(R.id.tv_endereco_restaurante)
            horarioFuncionamento = itemView.findViewById(R.id.tv_horario_funcionamento)
            btnProcurar = itemView.findViewById(R.id.cv_procurar)


            btnProcurar.setOnClickListener {
                restauranteItemClickListener.onRestauranteClick(mData[adapterPosition])
            }
        }
    }
}