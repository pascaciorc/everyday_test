package com.pascaciorc.everydaytest.data

import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.*
import com.pascaciorc.everydaytest.R
import kotlinx.android.synthetic.main.tile_item.view.*

@EpoxyModelClass(layout = R.layout.tile_item)
abstract class TileView : EpoxyModelWithHolder<TileView.TileHolder>() {

    @EpoxyAttribute
    var tile: Take? = null

    override fun bind(holder: TileHolder) {
        holder.numberText.text = tile?.id.toString()
    }

    inner class TileHolder: EpoxyHolder() {
        lateinit var numberText: TextView

        override fun bindView(itemView: View) {
            numberText = itemView.title_text
        }
    }
}