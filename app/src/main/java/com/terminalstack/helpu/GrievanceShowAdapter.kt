package com.terminalstack.helpu

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GrievanceShowAdapter(var context: Context?=null,val helpNotices:ArrayList<Helpdesk_Model>): RecyclerView.Adapter<GrievanceShowAdapter.HelpViewHolder>() {





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HelpViewHolder {
       val inflater:LayoutInflater= LayoutInflater.from(parent.context)
        val view:View=inflater.inflate(R.layout.helpdesk_recview_item,parent,false)
        return HelpViewHolder(view)

    }

    override fun onBindViewHolder(holder: HelpViewHolder, position: Int) {
        val notice: Helpdesk_Model = helpNotices.get(position)
        holder.grievanceTitle.text = notice.grievanceTitle
        holder.grievanceDesc.text = notice.grievanceDesc

    }

    override fun getItemCount(): Int {
        return helpNotices.size
    }

    class HelpViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        var grievanceTitle= itemView.findViewById<TextView>(R.id.idTVgrievanceTitle)
        var grievanceDesc=itemView.findViewById<TextView>(R.id.idTVgrievanceData)

    }


}
