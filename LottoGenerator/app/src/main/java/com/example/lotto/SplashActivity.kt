package com.example.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.core.os.postDelayed


//앱 실행 시 짧은 인트로로 보이는 화면
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //인트로 화면에서 3초 이상 지연시 자동으로 메인 액티비티 화면으로 전환
        val handler = Handler(Looper.getMainLooper())
        val runnable = Runnable{
            val mainIntent = Intent(this, MainActivity::class.java)
            startActivity(mainIntent)
            finish()
        }

        handler.postDelayed(runnable,3000)

        //인트로 화면 클릭 시 메인 액티비티 화면으로 전환
        val animationView = findViewById<View>(R.id.animationView)
        animationView.setOnClickListener{
            handler.removeCallbacks(runnable)//화면 클릭시 runnable에 등록된 콜백이 제거됨
            val mainIntent = Intent(this,MainActivity::class.java)
            startActivity(mainIntent)
            finish()//액티비티 종료
        }
    }
}