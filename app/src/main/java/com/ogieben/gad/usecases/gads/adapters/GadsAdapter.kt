package com.ogieben.gad.usecases.gads.adapters

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.ogieben.gad.R
import com.ogieben.gad.data.models.gad.Student
import com.ogieben.gad.data.models.gad.StudentHours
import com.ogieben.gad.data.models.gad.StudentIQ
import com.ogieben.gad.utils.ImageUtil


class GadsAdapter(private var students: ArrayList<Student>) :
    RecyclerView.Adapter<GadsAdapter.GadsViewHolder>() {

    class GadsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GadsViewHolder {

        return GadsViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.student_item_card, parent, false) as CardView
        )

    }

    override fun getItemCount(): Int {
        return students.size
    }

    override fun onBindViewHolder(holder: GadsViewHolder, position: Int) {
        setCardDetails(students[position], holder.itemView)
    }

    fun refreshStudentData(students: ArrayList<Student>) {
        this.students.clear()
        this.students.addAll(students)
        notifyDataSetChanged()
    }

    private fun setCardDetails(student: Student, card: View) {
        if (student.badgeUrl!!.isNotEmpty()) {
            ImageUtil.fetchImage(Uri.parse(student.badgeUrl), card.findViewById(R.id.imageView))
        }

        card.findViewById<TextView>(R.id.studentName).apply {
            text = student.name
        }
        card.findViewById<TextView>(R.id.learningHours).apply {
            val transformText = if (student is StudentIQ) "${student.score} Skill IQ Score" else "${(student as StudentHours).hours} learning hours"
            text = transformText
        }
        card.findViewById<TextView>(R.id.country).apply {
            text = student.country
        }
    }
}

