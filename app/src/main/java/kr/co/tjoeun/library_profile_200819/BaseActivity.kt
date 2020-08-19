package kr.co.tjoeun.library_profile_200819

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    val mContext = this

    abstract fun setUpEvents()

    abstract fun setValues()

}