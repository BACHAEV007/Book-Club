package com.example.booksapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.State
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.booksapp.data.Book
import com.example.booksapp.databinding.CarouselItemBinding
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.ShapeAppearanceModel

class CarouselAdapter(
    private val bookList: List<Book>,
    private val currentItemState: State<Int>
) :
    RecyclerView.Adapter<CarouselAdapter.ViewHolder>() {

    class ViewHolder(val binding: CarouselItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            CarouselItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val maskableFrameLayout = binding.carouselItemContainer
        maskableFrameLayout.setShapeAppearanceModel(
            ShapeAppearanceModel.builder()
                .setAllCorners(
                    CornerFamily.ROUNDED,
                    8f * parent.context.resources.displayMetrics.density
                )
                .build()
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val book = bookList[position]
        Glide.with(holder.itemView.context)
            .load(book.imageUrl)
            .into(holder.binding.carouselImageView)

        holder.binding.authorTextView.text = book.title
        holder.binding.descriptionTextView.text = book.description

        holder.binding.textContainer.visibility = if (position == currentItemState.value) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }


    override fun getItemCount(): Int = bookList.size
}