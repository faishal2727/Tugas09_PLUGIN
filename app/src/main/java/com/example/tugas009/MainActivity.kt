package com.example.tugas009

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugas009.adapter.halaman
import com.example.tugas009.realm.realmclass
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var realm : Realm
    lateinit var halaman: halaman
    val tugas = LinearLayoutManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addData()
        initView()
        getAlluser()
    }
    fun addData() {
        btn1.setOnClickListener {
            realm.beginTransaction()
            var count = 0
            realm.where(realmclass::class.java).findAll().let {
                for (i in it) {
                    count++
                }
            }
            var user = realm.createObject(realmclass::class.java)
            user.setId(count + 1)
            user.setNama(et1.text.toString())
            user.setEmail(et2.text.toString())
            getAlluser()
            et3.setText("")
            et1.setText("")
            et2.setText("")
            realm.commitTransaction()
        }
        btn2.setOnClickListener {
            realm.beginTransaction()
            realm.where(realmclass::class.java).equalTo("id", et1.text.toString().toInt())
                .findFirst().let {
                it!!.setNama(et1.text.toString())
                it!!.setEmail(et2.text.toString())
            }
            realm.commitTransaction()
        }
        btn3.setOnClickListener {
            realm.beginTransaction()
            realm.where(realmclass::class.java).equalTo("id", et1.text.toString().toString())
                .findFirst().let {
                it!!.deleteFromRealm()
                getAlluser()
            }
            realm.commitTransaction()

        }
    }
    fun initView(){
        rcy.layoutManager= tugas
        halaman= halaman(this)
        rcy.adapter = halaman
        realm =  Realm.getDefaultInstance()
        getAlluser()
    }
    fun getAlluser(){
    realm.where(realmclass::class.java).findAll().let {
        halaman.setUser(it)
    }
}}



