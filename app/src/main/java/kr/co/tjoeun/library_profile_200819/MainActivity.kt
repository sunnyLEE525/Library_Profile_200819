package kr.co.tjoeun.library_profile_200819

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpEvents()
        setValues()
}
    override fun setUpEvents() {

        callBtn.setOnClickListener {

//            전화(Call) 기능을 사용 가능한 상태인지 확인
//            => 사용 가능할때의 코드+불가능할 때의 코드 작성 후 실제 권한 요청

            val pl = object : PermissionListener {
                override fun onPermissionGranted() {
//                    권한이 승인된 상태일 때 실행할 코드

                    val myUri = Uri.parse("tel : 010-5555-6666")
                    val myIntent = Intent(Intent.ACTION_CALL, myUri)

                    startActivity(myIntent)
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
//                    권한이 거부되었을 때 실행할 코드
                    Toast.makeText(mContext, "전화연결이 거부되어 연결 불가능", Toast.LENGTH_SHORT).show()
                }
            }

//            완성된 행동 방침(가이드북)을 가지고 권한 실제 요청
            TedPermission.with(mContext)
                .setPermissionListener(pl)
                .setDeniedMessage("권한을 거부하면 통화가 불가능합니다. 설정 > 권한에서 허용해 주세요.")
                .setPermissions(Manifest.permission.CALL_PHONE)


//            전화를 바로 연결 처리(Action_Call)




        }

        profilePhotoImg.setOnClickListener {
//            사진을 크게

            val myIntent = Intent(mContext, ViewProfilePhotoActivity::class.java)
            startActivity(myIntent)

        }

    }

    override fun setValues() {

//        Glide로 웹상의 차은우 사진을 프사로 반영
        Glide.with(mContext).load("http://upload.wikimedia.org/wikipedia/commons/thumb/6/65/170924_%ED%91%B8%EB%93%9C%ED%8A%B8%EB%9F%AD%EC%9D%B4%EB%B2%A4%ED%8A%B8.jpg/250px-170924_%ED%91%B8%EB%93%9C%ED%8A%B8%EB%9F%AD%EC%9D%B4%EB%B2%A4%ED%8A%B8.jpg").into(profilePhotoImg)


    }


}