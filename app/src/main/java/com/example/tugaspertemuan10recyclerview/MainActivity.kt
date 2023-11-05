package com.example.tugaspertemuan10recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugaspertemuan10recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapterPahlawan = PahlawanAdapter(generateDummy()) {Pahlawan ->
            Toast.makeText(this@MainActivity,"${Pahlawan.PahlawanNama} Ialah ${Pahlawan.PahlawanPeran} Asal ${Pahlawan.PahlawanAsal}", Toast.LENGTH_SHORT).show()
        }

        with(binding) {
            rvPahlawan.apply {
                adapter = adapterPahlawan
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }

    private fun generateDummy(): List<Pahlawan> {
        return listOf(
            Pahlawan(R.drawable.irsoekarno, "I.R Soekarno", "Proklamator Kemerdekaan Indonesia", "Blitar"),
            Pahlawan(R.drawable.mohhatta, "Mohammad Hatta", "Proklamator Kemerdekaan Indonesia", "Bukittinggi"),
            Pahlawan(R.drawable.rakartini, "R.A Kartini","Pejuang Emansipasi Wanita", "Jepara"),
            Pahlawan(R.drawable.cutnyakdien, "Cut Nyak Dien", "Panglima Perang","Aceh"),
            Pahlawan(R.drawable.pangerandiponegoro, "Pangeran Diponegoro", "Panglima Perang","Yogyakarta"),
            Pahlawan(R.drawable.khdewantara, "Ki Hajar Dewantara", "Pendidik dan Pelopor Pendidikan Indonesia","Yogyakarta"),
        )
    }
}