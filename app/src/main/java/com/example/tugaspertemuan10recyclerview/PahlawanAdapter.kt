package com.example.tugaspertemuan10recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tugaspertemuan10recyclerview.databinding.ItemPahlawanBinding

typealias onClickPahlawan = (Pahlawan) -> Unit

class PahlawanAdapter(private val listPahlawan: List<Pahlawan>, private val onClickPahlawan: onClickPahlawan):
    RecyclerView.Adapter<PahlawanAdapter.ItemPahlawanViewHolder>() {

    inner class ItemPahlawanViewHolder(private val binding: ItemPahlawanBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Pahlawan) {
            with(binding) {
                namaPahlawan.text = data.PahlawanNama
                peranPahlawan.text = data.PahlawanPeran
                asalPahlawan.text = data.PahlawanAsal
                val gbr_pahlawan = when (data.PahlawanGambar){
                    R.drawable.irsoekarno -> R.drawable.irsoekarno
                    R.drawable.mohhatta -> R.drawable.mohhatta
                    R.drawable.rakartini->R.drawable.rakartini
                    R.drawable.cutnyakdien->R.drawable.cutnyakdien
                    R.drawable.pangerandiponegoro->R.drawable.pangerandiponegoro
                    R.drawable.khdewantara->R.drawable.khdewantara
                    else -> R.drawable.defaultt
                }
                gambarPahlawan.setImageResource(gbr_pahlawan)
                itemView.setOnClickListener {
                    onClickPahlawan(data)
                }
            }

        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ):ItemPahlawanViewHolder {
        val binding = ItemPahlawanBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false)
        return ItemPahlawanViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemPahlawanViewHolder, position: Int) {
        holder.bind(listPahlawan[position])
    }

    override fun getItemCount(): Int = listPahlawan.size
}