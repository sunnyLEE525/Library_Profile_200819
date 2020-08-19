package kr.co.tjoeun.library_profile_200819

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpEvents()
        setValues()
}
    override fun setUpEvents() {

        profilePhotoImg.setOnClickListener {
//            사진을 크게

            val myIntent = Intent(mContext, ViewProfilePhotoActivity::class.java)
            startActivity(myIntent)

        }

    }

    override fun setValues() {

//        Glide로 웹상의 차은우 사진을 프사로 반영
        Glide.with(mContext).load("https://upload.wikimedia.org/wikipedia/commons/thumb/6/65/170924_%ED%91%B8%EB%93%9C%ED%8A%B8%EB%9F%AD%EC%9D%B4%EB%B2%A4%ED%8A%B8.jpg/250px-170924_%ED%91%B8%EB%93%9C%ED%8A%B8%EB%9F%AD%EC%9D%B4%EB%B2%A4%ED%8A%B8.jpg").into(profilePhotoImg)


    }


}