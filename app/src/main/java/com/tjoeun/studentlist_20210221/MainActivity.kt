package com.tjoeun.studentlist_20210221

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.tjoeun.studentlist_20210221.adapters.StudentAdapter
import com.tjoeun.studentlist_20210221.datas.Student
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    실제 학생들을 담아줄 목록 변수.
    val mStudentList = ArrayList<Student>()

//    리스트뷰의 각각의 줄을 실제로 뿌려줄 어댑터 변수
    lateinit var mAdapter :StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mStudentList.add(Student("조경진",1988))
        mStudentList.add(Student("강서영",1990))
        mStudentList.add(Student("김윤경",1981))
        mStudentList.add(Student("박은희",1970))
        mStudentList.add(Student("신정범",1989))
        mStudentList.add(Student("오이슬",1994))
        mStudentList.add(Student("이이슬",1990))
        mStudentList.add(Student("이지인",1996))
        mStudentList.add(Student("채명호",1973))
        mStudentList.add(Student("최원종",1967))
        mStudentList.add(Student("최윤정",1987))

//        나중에 담아준다던 mAdapter에 실제 어댑터 대입
        mAdapter = StudentAdapter(this, R.layout.student_list_item, mStudentList)

//        리스트뷰의 어댑터로써 => mAdapter를 지정.
        studentListView.adapter = mAdapter

//        리스트뷰의 각 줄이 눌렸을 경우 대처
        studentListView.setOnItemClickListener { parent, view, position, id ->

//            position : 몇번 줄이 눌렸는지 알려줌.

//            클릭된 학생의 이름을 토스트로

            val clickedStudnet = mStudentList[position]

            Toast.makeText(this, clickedStudnet.name, Toast.LENGTH_SHORT).show()

        }

    }
}