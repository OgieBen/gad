package com.ogieben.gad.usecases.gads.ui.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ogieben.gad.R
import com.ogieben.gad.data.datasources.gad.remote.RemoteDataSourceImpl
import com.ogieben.gad.data.models.gad.Student
import com.ogieben.gad.data.repository.gad.interfaces.StudentRepository
import com.ogieben.gad.data.repository.gad.student.StudentRepositoryImpl
import com.ogieben.gad.network.wrappers.HttpNetworkWrapper
import com.ogieben.gad.usecases.gads.adapters.GadsAdapter
import org.koin.android.ext.android.inject

/**
 * A placeholder fragment containing a simple view.
 */
class PlaceholderFragment : Fragment() {

    private lateinit var pageViewModel: PageViewModel
    private val studentRepository: StudentRepository = StudentRepositoryImpl(RemoteDataSourceImpl(HttpNetworkWrapper()))
    private val  recyclerViewAdapter: GadsAdapter = GadsAdapter(ArrayList(0))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel::class.java).apply {
            val pageCounter = arguments?.getInt(ARG_SECTION_NUMBER) ?: 1
            setIndex(pageCounter)
            if (pageCounter == 1) fetchLearningLeaders(studentRepository) else  fetchStudentsWithTopIQs(studentRepository)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val rvLayoutManager = LinearLayoutManager(this.context)
        root.findViewById<RecyclerView>(R.id.gad_recycler_view).apply {
            adapter = recyclerViewAdapter
            layoutManager = rvLayoutManager
        }

        pageViewModel.students.observe(viewLifecycleOwner, Observer<List<Student>> {
           recyclerViewAdapter.refreshStudentData(it as ArrayList<Student>)
        })
        return root
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): PlaceholderFragment {
            return PlaceholderFragment()
                .apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}