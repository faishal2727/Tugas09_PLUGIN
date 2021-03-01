package com.example.tugas009.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tugas009.R
import com.example.tugas009.realm.realmclass
import com.example.tugas009.tugas9
import kotlinx.android.synthetic.main.tampilan.view.*

class halaman (val context: Context):RecyclerView.Adapter<halaman.UserViewHolder>(){
    private val users : MutableList<realmclass> = mutableListOf()
    inner class UserViewHolder (i : View) :RecyclerView.ViewHolder(i){
        val no1 : TextView = i.findViewById(R.id.teks1)
        val no2 : TextView = i.findViewById(R.id.teks2)
        val no3 : TextView = i.findViewById(R.id.teks3)
        fun bindView(u : realmclass){
            no1.text = u.getId().toString()
            no2.text = u.getNama()
            no3.text = u.getEmail()

        }
    }
    fun setUser(data : List<realmclass>){
        users.clear()
        users.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder((LayoutInflater.from(context).inflate(R.layout.tampilan,parent,false)))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bindView(users[position])
    }

    override fun getItemCount(): Int {
        return users.size
    }

}