package com.ogieben.gad.usecases.gads.ui.submission

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.ogieben.gad.R
import com.ogieben.gad.data.datasources.gad.remote.RemoteDataSourceImpl
import com.ogieben.gad.data.repository.gad.interfaces.StudentRepository
import com.ogieben.gad.data.repository.gad.student.StudentRepositoryImpl
import com.ogieben.gad.network.wrappers.HttpNetworkWrapper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SubmissionActivity : AppCompatActivity() {

    private var confirmationDialog: AlertDialog? = null
    private var resultDialog: AlertDialog? = null
    private val studentRepository: StudentRepository = StudentRepositoryImpl(
        RemoteDataSourceImpl(
            HttpNetworkWrapper()
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submission)
        setSupportActionBar(findViewById(R.id.toolbar))
        confirmationDialog = buildConfirmationDialog()

        findViewById<Button>(R.id.submitButton).setOnClickListener {
            confirmationDialog!!.show()
        }
    }

    private fun handleSubmission(){
        val firstName = findViewById<EditText>(R.id.firstName)
        val lastName = findViewById<EditText>(R.id.lastName)
        val email = findViewById<EditText>(R.id.email)
        val githubLink = findViewById<EditText>(R.id.githubLink)

        studentRepository
            .submitProject(firstName.text.toString(), lastName.text.toString(), email.text.toString(), githubLink.text.toString())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                resultDialog = buildResultDialog(true)
                resultDialog!!.show()
                Log.e(this::class.java.simpleName, it.toString())
            },{
                resultDialog = buildResultDialog(false)
                resultDialog!!.show()
                Log.e(this::class.java.simpleName, it.message.toString())
            })
    }

    private fun hide() {
        handleSubmission()
        confirmationDialog!!.hide()
    }

    private fun hideResultDialog() {
        resultDialog!!.hide()
    }

    private fun buildConfirmationDialog(): AlertDialog {
        return this?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = this.layoutInflater;
            val view: View = inflater.inflate(R.layout.confirmation_dialog, null)
            view.findViewById<Button>(R.id.confirmationButton).setOnClickListener {
                hide()
            }
            builder.setView(view)
            builder.create()
        }
    }

    private fun buildResultDialog(success: Boolean): AlertDialog {
        return this?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = this.layoutInflater;
            val view: View = if(success) inflater.inflate(R.layout.success_dialog, null) else inflater.inflate(R.layout.error_dialog, null)
            view.findViewById<ImageButton>(R.id.close).setOnClickListener {
                hideResultDialog()
            }
            builder.setView(view)
            builder.create()
        }
    }
}