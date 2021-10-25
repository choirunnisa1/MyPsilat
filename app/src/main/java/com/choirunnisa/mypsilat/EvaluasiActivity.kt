package com.choirunnisa.mypsilat

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_evaluasi.*
import java.util.*

class EvaluasiActivity : AppCompatActivity(), View.OnClickListener {

    var randomSoal: ArrayList<Int> = ArrayList()

    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedPosition: Int = 0
    private var mCorrectAnswers: Int = 0


    private var answer: Int =0
    private var urutan = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_evaluasi)

        mQuestionList = Constants.getQuestion()
        mQuestionList!!.shuffle()

        setQuestion()

        optionOne.setOnClickListener(this)
        optionTwo.setOnClickListener(this)
        optionTree.setOnClickListener(this)
        optionFour.setOnClickListener(this)
        optionFive.setOnClickListener(this)
        btn_submit.setOnClickListener(this)
    }

    private fun setQuestion() {

        val question = mQuestionList!!.get(mCurrentPosition-1)
        Log.d("total","soal ${mQuestionList?.size}")

        defaultOptionsView()

        if (mCurrentPosition == mQuestionList!!.size) {

            btn_submit.text = "SELESAI"
        } else {

            btn_submit.text = "SUBMIT"
        }

        tv_question.text = question.question
        optionOne.text = question.optionOne
        optionTwo.text = question.optionTwo
        optionTree.text = question.optionTree
        optionFour.text = question.optionFour
        optionFive.text = question.optionFive
        answer = question.correctAnswer

        tv_progress.text = "$mCurrentPosition"+"/"+"${mQuestionList?.size}"

    }

    override fun onBackPressed() {
        if (mCurrentPosition == 1) {
            val closeIntent = Intent(this, MainActivity::class.java)
            closeIntent.addCategory(Intent.CATEGORY_HOME)
            closeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(closeIntent)
        } else Toast.makeText(this, "Tidak bisa kembali, selesaikan soal terlebih dahulu", Toast.LENGTH_SHORT).show();
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.optionOne -> {
                selectedOptionView(optionOne, 1)
            }
            R.id.optionTwo -> {
                selectedOptionView(optionTwo, 2)
            }
            R.id.optionTree -> {
                selectedOptionView(optionTree, 3)
            }
            R.id.optionFour -> {
                selectedOptionView(optionFour, 4)
            }
            R.id.optionFive -> {
                selectedOptionView(optionFive, 5)
            }
            R.id.btn_submit -> {
                if (mSelectedPosition == 0) {
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this, SkorActivity::class.java)
                            intent.putExtra(Constants.CORRECT_ANSWER, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTION, mQuestionList!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {

                    if (answer!= mSelectedPosition) {
                        answerView(mSelectedPosition, R.drawable.uncorrect_option)
                    } else {
                        mCorrectAnswers++
                    }
                    answerView(answer, R.drawable.correct_option)

                    if (mCurrentPosition == mQuestionList!!.size) {
                        btn_submit.text = "SELESAI"
                    } else {
                        btn_submit.text = "SOAL SELANJUTNYA"
                    }
                    mSelectedPosition = 0
                }
            }
        }
    }

    private fun selectedOptionView(textView: TextView,
                                   selectedOptionNum: Int) {
        defaultOptionsView()
        mSelectedPosition = selectedOptionNum

        textView.setTextColor(Color.parseColor("#363a43"))
        textView.background = ContextCompat.getDrawable(this, R.drawable.selected_option)
    }


    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        options.add(0, optionOne)
        options.add(1, optionTwo)
        options.add(2, optionTree)
        options.add(3, optionFour)
        options.add(4, optionFive)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.background = ContextCompat.getDrawable(this, R.drawable.background_option)
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                optionOne.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            2 -> {
                optionTwo.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            3 -> {
                optionTree.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            4 -> {
                optionFour.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            5 -> {
                optionFive.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
        }
    }

}