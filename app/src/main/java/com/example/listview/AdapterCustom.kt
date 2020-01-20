package com.example.listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class AdapterCustom(var context: Context, items:ArrayList<Fruits>): BaseAdapter() {

    var items:ArrayList<Fruits>? = null

    init {
        this.items = items
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var holder:ViewHolder? = null

        var view:View? = convertView

        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.template, null)
            holder = ViewHolder(view)
            view.tag = holder
        }else{
            holder = view.tag as? ViewHolder
        }

        val item = getItem(position) as Fruits
        holder?.name?.text = item.name
        holder?.image?.setImageResource(item.image)

        return view!!
    }

    override fun getItem(position: Int): Any {
        return items?.get(position)!!
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return items?.count()!!
    }

    private class ViewHolder(view:View){
        var name:TextView? = null
        var image:ImageView? = null

        init {
            name = view.findViewById(R.id.tvName)
            image = view.findViewById(R.id.imgvFruit)
        }
    }

}